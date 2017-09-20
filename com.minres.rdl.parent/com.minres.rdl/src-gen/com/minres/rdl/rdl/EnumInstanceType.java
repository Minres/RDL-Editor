/**
 * generated by Xtext 2.12.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Instance Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.EnumInstanceType#getEXTERNAL <em>EXTERNAL</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.EnumInstanceType#getINTERNAL <em>INTERNAL</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getEnumInstanceType()
 * @model
 * @generated
 */
public interface EnumInstanceType extends EObject
{
  /**
   * Returns the value of the '<em><b>EXTERNAL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EXTERNAL</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EXTERNAL</em>' attribute.
   * @see #setEXTERNAL(String)
   * @see com.minres.rdl.rdl.RdlPackage#getEnumInstanceType_EXTERNAL()
   * @model
   * @generated
   */
  String getEXTERNAL();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.EnumInstanceType#getEXTERNAL <em>EXTERNAL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>EXTERNAL</em>' attribute.
   * @see #getEXTERNAL()
   * @generated
   */
  void setEXTERNAL(String value);

  /**
   * Returns the value of the '<em><b>INTERNAL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>INTERNAL</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>INTERNAL</em>' attribute.
   * @see #setINTERNAL(String)
   * @see com.minres.rdl.rdl.RdlPackage#getEnumInstanceType_INTERNAL()
   * @model
   * @generated
   */
  String getINTERNAL();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.EnumInstanceType#getINTERNAL <em>INTERNAL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>INTERNAL</em>' attribute.
   * @see #getINTERNAL()
   * @generated
   */
  void setINTERNAL(String value);

} // EnumInstanceType