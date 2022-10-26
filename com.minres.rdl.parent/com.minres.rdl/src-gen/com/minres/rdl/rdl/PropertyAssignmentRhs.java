/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Assignment Rhs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getValue <em>Value</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getInstPropRef <em>Inst Prop Ref</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getEnumRef <em>Enum Ref</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getEnums <em>Enums</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getPropertyAssignmentRhs()
 * @model
 * @generated
 */
public interface PropertyAssignmentRhs extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(RValue)
   * @see com.minres.rdl.rdl.RdlPackage#getPropertyAssignmentRhs_Value()
   * @model containment="true"
   * @generated
   */
  RValue getValue();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(RValue value);

  /**
   * Returns the value of the '<em><b>Inst Prop Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inst Prop Ref</em>' containment reference.
   * @see #setInstPropRef(InstancePropertyRef)
   * @see com.minres.rdl.rdl.RdlPackage#getPropertyAssignmentRhs_InstPropRef()
   * @model containment="true"
   * @generated
   */
  InstancePropertyRef getInstPropRef();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getInstPropRef <em>Inst Prop Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inst Prop Ref</em>' containment reference.
   * @see #getInstPropRef()
   * @generated
   */
  void setInstPropRef(InstancePropertyRef value);

  /**
   * Returns the value of the '<em><b>Enum Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Ref</em>' reference.
   * @see #setEnumRef(EnumDefinition)
   * @see com.minres.rdl.rdl.RdlPackage#getPropertyAssignmentRhs_EnumRef()
   * @model
   * @generated
   */
  EnumDefinition getEnumRef();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getEnumRef <em>Enum Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Ref</em>' reference.
   * @see #getEnumRef()
   * @generated
   */
  void setEnumRef(EnumDefinition value);

  /**
   * Returns the value of the '<em><b>Enums</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enums</em>' containment reference.
   * @see #setEnums(EnumBody)
   * @see com.minres.rdl.rdl.RdlPackage#getPropertyAssignmentRhs_Enums()
   * @model containment="true"
   * @generated
   */
  EnumBody getEnums();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getEnums <em>Enums</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enums</em>' containment reference.
   * @see #getEnums()
   * @generated
   */
  void setEnums(EnumBody value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference.
   * @see #setElements(Concat)
   * @see com.minres.rdl.rdl.RdlPackage#getPropertyAssignmentRhs_Elements()
   * @model containment="true"
   * @generated
   */
  Concat getElements();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.PropertyAssignmentRhs#getElements <em>Elements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elements</em>' containment reference.
   * @see #getElements()
   * @generated
   */
  void setElements(Concat value);

} // PropertyAssignmentRhs
