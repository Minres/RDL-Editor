/**
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.rdl.impl;

import com.minres.rdl.rdl.EnumInstanceType;
import com.minres.rdl.rdl.RdlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Instance Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.minres.rdl.rdl.impl.EnumInstanceTypeImpl#getEXTERNAL <em>EXTERNAL</em>}</li>
 *   <li>{@link com.minres.rdl.rdl.impl.EnumInstanceTypeImpl#getINTERNAL <em>INTERNAL</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumInstanceTypeImpl extends MinimalEObjectImpl.Container implements EnumInstanceType
{
  /**
   * The default value of the '{@link #getEXTERNAL() <em>EXTERNAL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEXTERNAL()
   * @generated
   * @ordered
   */
  protected static final String EXTERNAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEXTERNAL() <em>EXTERNAL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEXTERNAL()
   * @generated
   * @ordered
   */
  protected String external = EXTERNAL_EDEFAULT;

  /**
   * The default value of the '{@link #getINTERNAL() <em>INTERNAL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getINTERNAL()
   * @generated
   * @ordered
   */
  protected static final String INTERNAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getINTERNAL() <em>INTERNAL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getINTERNAL()
   * @generated
   * @ordered
   */
  protected String internal = INTERNAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumInstanceTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RdlPackage.Literals.ENUM_INSTANCE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getEXTERNAL()
  {
    return external;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEXTERNAL(String newEXTERNAL)
  {
    String oldEXTERNAL = external;
    external = newEXTERNAL;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdlPackage.ENUM_INSTANCE_TYPE__EXTERNAL, oldEXTERNAL, external));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getINTERNAL()
  {
    return internal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setINTERNAL(String newINTERNAL)
  {
    String oldINTERNAL = internal;
    internal = newINTERNAL;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdlPackage.ENUM_INSTANCE_TYPE__INTERNAL, oldINTERNAL, internal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RdlPackage.ENUM_INSTANCE_TYPE__EXTERNAL:
        return getEXTERNAL();
      case RdlPackage.ENUM_INSTANCE_TYPE__INTERNAL:
        return getINTERNAL();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RdlPackage.ENUM_INSTANCE_TYPE__EXTERNAL:
        setEXTERNAL((String)newValue);
        return;
      case RdlPackage.ENUM_INSTANCE_TYPE__INTERNAL:
        setINTERNAL((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RdlPackage.ENUM_INSTANCE_TYPE__EXTERNAL:
        setEXTERNAL(EXTERNAL_EDEFAULT);
        return;
      case RdlPackage.ENUM_INSTANCE_TYPE__INTERNAL:
        setINTERNAL(INTERNAL_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RdlPackage.ENUM_INSTANCE_TYPE__EXTERNAL:
        return EXTERNAL_EDEFAULT == null ? external != null : !EXTERNAL_EDEFAULT.equals(external);
      case RdlPackage.ENUM_INSTANCE_TYPE__INTERNAL:
        return INTERNAL_EDEFAULT == null ? internal != null : !INTERNAL_EDEFAULT.equals(internal);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (EXTERNAL: ");
    result.append(external);
    result.append(", INTERNAL: ");
    result.append(internal);
    result.append(')');
    return result.toString();
  }

} //EnumInstanceTypeImpl
