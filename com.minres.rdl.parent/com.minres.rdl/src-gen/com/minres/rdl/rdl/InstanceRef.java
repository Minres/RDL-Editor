/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.InstanceRef#getInstance <em>Instance</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.InstanceRef#getTail <em>Tail</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getInstanceRef()
 * @model
 * @generated
 */
public interface InstanceRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance</em>' reference.
   * @see #setInstance(Entity)
   * @see com.minres.rdl.rdl.RdlPackage#getInstanceRef_Instance()
   * @model
   * @generated
   */
  Entity getInstance();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.InstanceRef#getInstance <em>Instance</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance</em>' reference.
   * @see #getInstance()
   * @generated
   */
  void setInstance(Entity value);

  /**
   * Returns the value of the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tail</em>' containment reference.
   * @see #setTail(InstanceRef)
   * @see com.minres.rdl.rdl.RdlPackage#getInstanceRef_Tail()
   * @model containment="true"
   * @generated
   */
  InstanceRef getTail();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.InstanceRef#getTail <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tail</em>' containment reference.
   * @see #getTail()
   * @generated
   */
  void setTail(InstanceRef value);

} // InstanceRef
