/**
 * generated by Xtext 2.13.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concat Elem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.ConcatElem#getInstPropRef <em>Inst Prop Ref</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.ConcatElem#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getConcatElem()
 * @model
 * @generated
 */
public interface ConcatElem extends EObject
{
  /**
   * Returns the value of the '<em><b>Inst Prop Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inst Prop Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inst Prop Ref</em>' containment reference.
   * @see #setInstPropRef(InstancePropertyRef)
   * @see com.minres.rdl.rdl.RdlPackage#getConcatElem_InstPropRef()
   * @model containment="true"
   * @generated
   */
  InstancePropertyRef getInstPropRef();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.ConcatElem#getInstPropRef <em>Inst Prop Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inst Prop Ref</em>' containment reference.
   * @see #getInstPropRef()
   * @generated
   */
  void setInstPropRef(InstancePropertyRef value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(Object)
   * @see com.minres.rdl.rdl.RdlPackage#getConcatElem_Value()
   * @model
   * @generated
   */
  Object getValue();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.ConcatElem#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(Object value);

} // ConcatElem
