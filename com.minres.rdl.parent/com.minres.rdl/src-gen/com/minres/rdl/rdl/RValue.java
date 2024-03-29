/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RValue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.RValue#getVal <em>Val</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.RValue#getNum <em>Num</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.RValue#getStr <em>Str</em>}</li>
 * </ul>
 *
 * @see com.minres.rdl.rdl.RdlPackage#getRValue()
 * @model
 * @generated
 */
public interface RValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * The literals are from the enumeration {@link com.minres.rdl.rdl.RValueConstant}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see com.minres.rdl.rdl.RValueConstant
   * @see #setVal(RValueConstant)
   * @see com.minres.rdl.rdl.RdlPackage#getRValue_Val()
   * @model
   * @generated
   */
  RValueConstant getVal();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.RValue#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see com.minres.rdl.rdl.RValueConstant
   * @see #getVal()
   * @generated
   */
  void setVal(RValueConstant value);

  /**
   * Returns the value of the '<em><b>Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num</em>' attribute.
   * @see #setNum(Object)
   * @see com.minres.rdl.rdl.RdlPackage#getRValue_Num()
   * @model
   * @generated
   */
  Object getNum();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.RValue#getNum <em>Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num</em>' attribute.
   * @see #getNum()
   * @generated
   */
  void setNum(Object value);

  /**
   * Returns the value of the '<em><b>Str</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Str</em>' attribute.
   * @see #setStr(String)
   * @see com.minres.rdl.rdl.RdlPackage#getRValue_Str()
   * @model
   * @generated
   */
  String getStr();

  /**
   * Sets the value of the '{@link com.minres.rdl.rdl.RValue#getStr <em>Str</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Str</em>' attribute.
   * @see #getStr()
   * @generated
   */
  void setStr(String value);

} // RValue
