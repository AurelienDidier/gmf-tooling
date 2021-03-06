/**
 * Copyright (c) 2007-2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.diagram.commands

import com.google.inject.Inject
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import xpt.Common
import xpt.diagram.Utils_qvto
import xpt.diagram.editpolicies.BaseItemSemanticEditPolicy

@com.google.inject.Singleton class CreateLinkUtils {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject MetaModel xptMetaModel;
	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;

	/**
	* Check whether link may be created.
	*/
	def canCreate(LinkModelFacet it, GenLink link) ''' 
		
			«generatedMemberComment()» 
			public boolean canExecute() {
				if (source == null && target == null) {
					return false;
				}
				if (source != null && «xptMetaModel.NotInstance(it.sourceType, 'source')») {
					return false;
				}
				if (target != null && «xptMetaModel.NotInstance(it.targetType, 'target')») {
					return false;
				}
				if (getSource() == null) {
					return true; // link creation is in progress; source is not defined yet
				}
				// target may be null here but it's possible to check constraint
				«canCreateElement(it, link)»
			}
	'''

	def dispatch canCreateElement(LinkModelFacet it, GenLink link) ''''''

	def dispatch canCreateElement(TypeLinkModelFacet it, GenLink link) ''' 
		«IF hasContainerOtherThanSource(it)»
			if (getContainer() == null) {
				return false;
			}
		«ENDIF»
			return «xptBaseItemSemanticEditPolicy.canCreateCall(it, link, 'getContainer()', 'getSource()', 'getTarget()')»;
	'''

	def dispatch canCreateElement(FeatureLinkModelFacet it, GenLink link) ''' 
		return «xptBaseItemSemanticEditPolicy.canCreateCall(it, link, 'getSource()', 'getTarget()')»;
	'''

	/**
	 *	Fields of command that creates link.
	 */
	def dispatch fields(LinkModelFacet it) '''
		«extraLineBreak»
			«generatedMemberComment()» 
			private final org.eclipse.emf.ecore.EObject source;
		
			«generatedMemberComment()» 
			private final org.eclipse.emf.ecore.EObject target;
	'''

	def dispatch fields(TypeLinkModelFacet it) ''' 
		«extraLineBreak»
			«generatedMemberComment()» 
			private final org.eclipse.emf.ecore.EObject source;
		
			«generatedMemberComment()» 
			private final org.eclipse.emf.ecore.EObject target;
		«IF hasContainerOtherThanSource(it)»
			
			«generatedMemberComment()» 
			private final «xptMetaModel.QualifiedClassName(it.containmentMetaFeature.genClass)» container;
		«ENDIF»
	'''

	/**
	 *	Field accessors of command that creates link.
	**/
	def accessors(LinkModelFacet it) ''' 
		«generatedMemberComment()» 
		protected «xptMetaModel.QualifiedClassName(it.sourceType)» getSource() {
			return «xptMetaModel.CastEObject(it.sourceType, 'source')»;
		}
		
		«generatedMemberComment()» 
		protected «xptMetaModel.QualifiedClassName(it.targetType)» getTarget() {
			return «xptMetaModel.CastEObject(it.targetType, 'target')»;
		}
		«containerAccessor(it)»
	'''

	def dispatch containerAccessor(LinkModelFacet it) ''''''

	def dispatch containerAccessor(TypeLinkModelFacet it) ''' 
		«IF hasContainerOtherThanSource(it)»
		
			«generatedMemberComment()» 
			public «xptMetaModel.QualifiedClassName(it.containmentMetaFeature.genClass)» getContainer() {
				return container;
			}
		
			«generatedMemberComment(
				'Default approach is to traverse ancestors of the source to find instance of container.\n' +
					'Modify with appropriate logic.'
			)»
			private static «xptMetaModel.QualifiedClassName(it.containmentMetaFeature.genClass)» deduceContainer(org.eclipse.emf.ecore.EObject source, org.eclipse.emf.ecore.EObject target) {
				// Find container element for the new link.
				// Climb up by containment hierarchy starting from the source
				// and return the first element that is instance of the container class.
				for (org.eclipse.emf.ecore.EObject element = source; element != null; element = element.eContainer()) {
					if («xptMetaModel.IsInstance(containmentMetaFeature.genClass, 'element')») {
						return «xptMetaModel.CastEObject(it.containmentMetaFeature.genClass, 'element')»;
					}
				}
				return null;
			}
		«ENDIF»

'''

	/**
	 * Part of the constructor that performs initialization.
 	*/
	def dispatch initAndDeduceContainerIfNeeded(LinkModelFacet it) ''' 
		this.source = source;
		this.target = target;
	'''

	def dispatch initAndDeduceContainerIfNeeded(TypeLinkModelFacet it) ''' 
		this.source = source;
		this.target = target;
		«IF hasContainerOtherThanSource(it)»
			container = deduceContainer(source, target);
		«ENDIF»
	'''

}
