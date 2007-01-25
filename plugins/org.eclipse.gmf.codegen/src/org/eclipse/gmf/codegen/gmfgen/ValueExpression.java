/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Expression as a is textual statement which results in a value when evaluated in a context
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ValueExpression#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ValueExpression#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.ValueExpression#getLangName <em>Lang Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getValueExpression()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='ValueSpec'"
 * @generated
 */
public interface ValueExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The text of the expression
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getValueExpression_Body()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='body'"
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ValueExpression#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The default value is <code>"ocl"</code>.
	 * The literals are from the enumeration {@link org.eclipse.gmf.codegen.gmfgen.GenLanguage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the language in which the expression is stated
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see org.eclipse.gmf.codegen.gmfgen.GenLanguage
	 * @see #setLanguage(GenLanguage)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getValueExpression_Language()
	 * @model default="ocl" required="true"
	 * @generated
	 */
	GenLanguage getLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.ValueExpression#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see org.eclipse.gmf.codegen.gmfgen.GenLanguage
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(GenLanguage value);

	/**
	 * Returns the value of the '<em><b>Lang Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lang Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lang Name</em>' attribute.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getValueExpression_LangName()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='lang'"
	 * @generated
	 */
	String getLangName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns valid String literal for the given <code>String</code> as it should appear in java source code.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getBodyString();

	boolean isOCLExpression();
		
} // ValueExpression
