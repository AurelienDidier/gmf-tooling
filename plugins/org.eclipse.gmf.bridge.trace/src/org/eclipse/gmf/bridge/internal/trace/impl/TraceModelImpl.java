/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.bridge.internal.trace.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.bridge.internal.trace.AbstractTrace;
import org.eclipse.gmf.bridge.internal.trace.GenChildNodeTrace;
import org.eclipse.gmf.bridge.internal.trace.GenLinkTrace;
import org.eclipse.gmf.bridge.internal.trace.GenNodeTrace;
import org.eclipse.gmf.bridge.internal.trace.ToolGroupTrace;
import org.eclipse.gmf.bridge.internal.trace.TraceModel;
import org.eclipse.gmf.bridge.internal.trace.TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.impl.TraceModelImpl#getNodeTraces <em>Node Traces</em>}</li>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.impl.TraceModelImpl#getChildNodeTraces <em>Child Node Traces</em>}</li>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.impl.TraceModelImpl#getLinkTraces <em>Link Traces</em>}</li>
 *   <li>{@link org.eclipse.gmf.bridge.internal.trace.impl.TraceModelImpl#getToolGroupTraces <em>Tool Group Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceModelImpl extends EObjectImpl implements TraceModel {
	/**
	 * The cached value of the '{@link #getNodeTraces() <em>Node Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTraces()
	 * @generated
	 * @ordered
	 */
	protected EList nodeTraces = null;

	/**
	 * The cached value of the '{@link #getChildNodeTraces() <em>Child Node Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildNodeTraces()
	 * @generated
	 * @ordered
	 */
	protected EList childNodeTraces = null;

	/**
	 * The cached value of the '{@link #getLinkTraces() <em>Link Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkTraces()
	 * @generated
	 * @ordered
	 */
	protected EList linkTraces = null;

	/**
	 * The cached value of the '{@link #getToolGroupTraces() <em>Tool Group Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolGroupTraces()
	 * @generated
	 * @ordered
	 */
	protected EList toolGroupTraces = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TracePackage.Literals.TRACE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNodeTraces() {
		if (nodeTraces == null) {
			nodeTraces = new EObjectContainmentEList(GenNodeTrace.class, this, TracePackage.TRACE_MODEL__NODE_TRACES);
		}
		return nodeTraces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChildNodeTraces() {
		if (childNodeTraces == null) {
			childNodeTraces = new EObjectContainmentEList(GenChildNodeTrace.class, this, TracePackage.TRACE_MODEL__CHILD_NODE_TRACES);
		}
		return childNodeTraces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLinkTraces() {
		if (linkTraces == null) {
			linkTraces = new EObjectContainmentEList(GenLinkTrace.class, this, TracePackage.TRACE_MODEL__LINK_TRACES);
		}
		return linkTraces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getToolGroupTraces() {
		if (toolGroupTraces == null) {
			toolGroupTraces = new EObjectContainmentEList(ToolGroupTrace.class, this, TracePackage.TRACE_MODEL__TOOL_GROUP_TRACES);
		}
		return toolGroupTraces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GenNodeTrace getNodeTrace(int visualID) {
		for (Iterator it = getNodeTraces().iterator(); it.hasNext();) {
			GenNodeTrace nextTrace = (GenNodeTrace) it.next();
			if (nextTrace.getVisualID() == visualID) {
				return nextTrace;
			}
		}
		for (Iterator it = getChildNodeTraces().iterator(); it.hasNext();) {
			GenChildNodeTrace nextTrace = (GenChildNodeTrace) it.next();
			if (nextTrace.getVisualID() == visualID) {
				return nextTrace;
			}
		}

		throw new IllegalArgumentException("Node trace with id = " + visualID + " was not found");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GenLinkTrace getLinkTrace(int visualID) {
		for (Iterator it = getLinkTraces().iterator(); it.hasNext();) {
			GenLinkTrace nextTrace = (GenLinkTrace) it.next();
			if (nextTrace.getVisualID() == visualID) {
				return nextTrace;
			}
		}
		throw new IllegalArgumentException("Link trace with id = " + visualID + " was not found");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getAllAbstractTraces() {
		Collection result = new ArrayList();
		result.addAll(getNodeTraces());
		addNodeChildTraces(result, getNodeTraces());
		
		result.addAll(getChildNodeTraces());
		addNodeChildTraces(result, getChildNodeTraces());
		
		result.addAll(getLinkTraces());
		for (Iterator it = getLinkTraces().iterator(); it.hasNext();) {
			GenLinkTrace trace = (GenLinkTrace) it.next();
			result.addAll(trace.getLinkLabelTraces());
		}
		
		result.addAll(getToolGroupTraces());
		return new BasicEList.UnmodifiableEList(result.size(), result.toArray());
	}
	
	private void addNodeChildTraces(Collection collection, Collection nodeTraces) {
		for (Iterator it = nodeTraces.iterator(); it.hasNext();) {
			GenNodeTrace trace = (GenNodeTrace) it.next();
			collection.addAll(trace.getCompartmentTraces());
			collection.addAll(trace.getNodeLabelTraces());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void purgeUnprocessedTraces() {
		for (Iterator it = getAllAbstractTraces().iterator(); it.hasNext();) {
			AbstractTrace trace = (AbstractTrace) it.next();
			if (trace.isProcessed()) {
				continue;
			}
			System.out.println("Purging trace: " + trace);
			switch (trace.eClass().getClassifierID()) {
			case TracePackage.GEN_NODE_TRACE: 
				getNodeTraces().remove(trace);
				break;
			case TracePackage.GEN_CHILD_NODE_TRACE: 
				getChildNodeTraces().remove(trace);
				break;
			case TracePackage.GEN_LINK_TRACE: 
				getLinkTraces().remove(trace);
				break;
			case TracePackage.TOOL_GROUP_TRACE: 
				getToolGroupTraces().remove(trace);
				break;
			case TracePackage.GEN_NODE_LABEL_TRACE:
				((GenNodeTrace) trace.eContainer()).getNodeLabelTraces().remove(trace);
				break;
			case TracePackage.GEN_COMPARTMENT_TRACE:
				((GenNodeTrace) trace.eContainer()).getCompartmentTraces().remove(trace);
				break;
			case TracePackage.GEN_LINK_LABEL_TRACE:
				((GenLinkTrace) trace.eContainer()).getLinkLabelTraces().remove(trace);
				break;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TracePackage.TRACE_MODEL__NODE_TRACES:
				return ((InternalEList)getNodeTraces()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_MODEL__CHILD_NODE_TRACES:
				return ((InternalEList)getChildNodeTraces()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_MODEL__LINK_TRACES:
				return ((InternalEList)getLinkTraces()).basicRemove(otherEnd, msgs);
			case TracePackage.TRACE_MODEL__TOOL_GROUP_TRACES:
				return ((InternalEList)getToolGroupTraces()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TracePackage.TRACE_MODEL__NODE_TRACES:
				return getNodeTraces();
			case TracePackage.TRACE_MODEL__CHILD_NODE_TRACES:
				return getChildNodeTraces();
			case TracePackage.TRACE_MODEL__LINK_TRACES:
				return getLinkTraces();
			case TracePackage.TRACE_MODEL__TOOL_GROUP_TRACES:
				return getToolGroupTraces();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TracePackage.TRACE_MODEL__NODE_TRACES:
				getNodeTraces().clear();
				getNodeTraces().addAll((Collection)newValue);
				return;
			case TracePackage.TRACE_MODEL__CHILD_NODE_TRACES:
				getChildNodeTraces().clear();
				getChildNodeTraces().addAll((Collection)newValue);
				return;
			case TracePackage.TRACE_MODEL__LINK_TRACES:
				getLinkTraces().clear();
				getLinkTraces().addAll((Collection)newValue);
				return;
			case TracePackage.TRACE_MODEL__TOOL_GROUP_TRACES:
				getToolGroupTraces().clear();
				getToolGroupTraces().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TracePackage.TRACE_MODEL__NODE_TRACES:
				getNodeTraces().clear();
				return;
			case TracePackage.TRACE_MODEL__CHILD_NODE_TRACES:
				getChildNodeTraces().clear();
				return;
			case TracePackage.TRACE_MODEL__LINK_TRACES:
				getLinkTraces().clear();
				return;
			case TracePackage.TRACE_MODEL__TOOL_GROUP_TRACES:
				getToolGroupTraces().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TracePackage.TRACE_MODEL__NODE_TRACES:
				return nodeTraces != null && !nodeTraces.isEmpty();
			case TracePackage.TRACE_MODEL__CHILD_NODE_TRACES:
				return childNodeTraces != null && !childNodeTraces.isEmpty();
			case TracePackage.TRACE_MODEL__LINK_TRACES:
				return linkTraces != null && !linkTraces.isEmpty();
			case TracePackage.TRACE_MODEL__TOOL_GROUP_TRACES:
				return toolGroupTraces != null && !toolGroupTraces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TraceModelImpl