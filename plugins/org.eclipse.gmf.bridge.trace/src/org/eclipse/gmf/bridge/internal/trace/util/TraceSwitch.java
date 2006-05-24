/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.bridge.internal.trace.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.bridge.internal.trace.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.bridge.internal.trace.TracePackage
 * @generated
 */
public class TraceSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TracePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceSwitch() {
		if (modelPackage == null) {
			modelPackage = TracePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TracePackage.TRACE_MODEL: {
				TraceModel traceModel = (TraceModel)theEObject;
				Object result = caseTraceModel(traceModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.ABSTRACT_TRACE: {
				AbstractTrace abstractTrace = (AbstractTrace)theEObject;
				Object result = caseAbstractTrace(abstractTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.MATCHING_TRACE: {
				MatchingTrace matchingTrace = (MatchingTrace)theEObject;
				Object result = caseMatchingTrace(matchingTrace);
				if (result == null) result = caseAbstractTrace(matchingTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.GEN_NODE_TRACE: {
				GenNodeTrace genNodeTrace = (GenNodeTrace)theEObject;
				Object result = caseGenNodeTrace(genNodeTrace);
				if (result == null) result = caseMatchingTrace(genNodeTrace);
				if (result == null) result = caseAbstractTrace(genNodeTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.GEN_CHILD_NODE_TRACE: {
				GenChildNodeTrace genChildNodeTrace = (GenChildNodeTrace)theEObject;
				Object result = caseGenChildNodeTrace(genChildNodeTrace);
				if (result == null) result = caseGenNodeTrace(genChildNodeTrace);
				if (result == null) result = caseMatchingTrace(genChildNodeTrace);
				if (result == null) result = caseAbstractTrace(genChildNodeTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.GEN_NODE_LABEL_TRACE: {
				GenNodeLabelTrace genNodeLabelTrace = (GenNodeLabelTrace)theEObject;
				Object result = caseGenNodeLabelTrace(genNodeLabelTrace);
				if (result == null) result = caseMatchingTrace(genNodeLabelTrace);
				if (result == null) result = caseAbstractTrace(genNodeLabelTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.GEN_LINK_TRACE: {
				GenLinkTrace genLinkTrace = (GenLinkTrace)theEObject;
				Object result = caseGenLinkTrace(genLinkTrace);
				if (result == null) result = caseMatchingTrace(genLinkTrace);
				if (result == null) result = caseAbstractTrace(genLinkTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.GEN_COMPARTMENT_TRACE: {
				GenCompartmentTrace genCompartmentTrace = (GenCompartmentTrace)theEObject;
				Object result = caseGenCompartmentTrace(genCompartmentTrace);
				if (result == null) result = caseMatchingTrace(genCompartmentTrace);
				if (result == null) result = caseAbstractTrace(genCompartmentTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.GEN_LINK_LABEL_TRACE: {
				GenLinkLabelTrace genLinkLabelTrace = (GenLinkLabelTrace)theEObject;
				Object result = caseGenLinkLabelTrace(genLinkLabelTrace);
				if (result == null) result = caseMatchingTrace(genLinkLabelTrace);
				if (result == null) result = caseAbstractTrace(genLinkLabelTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TracePackage.TOOL_GROUP_TRACE: {
				ToolGroupTrace toolGroupTrace = (ToolGroupTrace)theEObject;
				Object result = caseToolGroupTrace(toolGroupTrace);
				if (result == null) result = caseMatchingTrace(toolGroupTrace);
				if (result == null) result = caseAbstractTrace(toolGroupTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTraceModel(TraceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Abstract Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Abstract Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbstractTrace(AbstractTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Matching Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Matching Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMatchingTrace(MatchingTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Node Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Node Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenNodeTrace(GenNodeTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Child Node Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Child Node Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenChildNodeTrace(GenChildNodeTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Node Label Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Node Label Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenNodeLabelTrace(GenNodeLabelTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Link Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Link Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenLinkTrace(GenLinkTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Compartment Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Compartment Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenCompartmentTrace(GenCompartmentTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Gen Link Label Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Gen Link Label Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGenLinkLabelTrace(GenLinkLabelTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Tool Group Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Tool Group Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseToolGroupTrace(ToolGroupTrace object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //TraceSwitch
