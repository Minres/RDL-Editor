/*
 * generated by Xtext 2.13.0
 */
package com.minres.rdl.serializer;

import com.google.inject.Inject;
import com.minres.rdl.rdl.ComponentDefinition;
import com.minres.rdl.rdl.ComponentInstance;
import com.minres.rdl.rdl.Concat;
import com.minres.rdl.rdl.ConcatElem;
import com.minres.rdl.rdl.EnumBody;
import com.minres.rdl.rdl.EnumDefinition;
import com.minres.rdl.rdl.EnumEntry;
import com.minres.rdl.rdl.EnumInstanceType;
import com.minres.rdl.rdl.EnumProperty;
import com.minres.rdl.rdl.ExplicitPropertyAssignment;
import com.minres.rdl.rdl.Include;
import com.minres.rdl.rdl.InstancePropertyRef;
import com.minres.rdl.rdl.InstanceRef;
import com.minres.rdl.rdl.Instantiation;
import com.minres.rdl.rdl.PostPropertyAssignment;
import com.minres.rdl.rdl.PropertyAssignmentRhs;
import com.minres.rdl.rdl.PropertyDefault;
import com.minres.rdl.rdl.PropertyDefinition;
import com.minres.rdl.rdl.PropertyUsage;
import com.minres.rdl.rdl.RValue;
import com.minres.rdl.rdl.Range;
import com.minres.rdl.rdl.RdlPackage;
import com.minres.rdl.rdl.Root;
import com.minres.rdl.services.RDLGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class RDLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private RDLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == RdlPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RdlPackage.COMPONENT_DEFINITION:
				sequence_ComponentDefinition(context, (ComponentDefinition) semanticObject); 
				return; 
			case RdlPackage.COMPONENT_INSTANCE:
				sequence_ComponentInstance(context, (ComponentInstance) semanticObject); 
				return; 
			case RdlPackage.CONCAT:
				sequence_Concat(context, (Concat) semanticObject); 
				return; 
			case RdlPackage.CONCAT_ELEM:
				sequence_ConcatElem(context, (ConcatElem) semanticObject); 
				return; 
			case RdlPackage.ENUM_BODY:
				sequence_EnumBody(context, (EnumBody) semanticObject); 
				return; 
			case RdlPackage.ENUM_DEFINITION:
				sequence_EnumDefinition(context, (EnumDefinition) semanticObject); 
				return; 
			case RdlPackage.ENUM_ENTRY:
				sequence_EnumEntry(context, (EnumEntry) semanticObject); 
				return; 
			case RdlPackage.ENUM_INSTANCE_TYPE:
				sequence_EnumInstanceType(context, (EnumInstanceType) semanticObject); 
				return; 
			case RdlPackage.ENUM_PROPERTY:
				sequence_EnumProperty(context, (EnumProperty) semanticObject); 
				return; 
			case RdlPackage.EXPLICIT_PROPERTY_ASSIGNMENT:
				sequence_ExplicitPropertyAssignment(context, (ExplicitPropertyAssignment) semanticObject); 
				return; 
			case RdlPackage.INCLUDE:
				sequence_Include(context, (Include) semanticObject); 
				return; 
			case RdlPackage.INSTANCE_PROPERTY_REF:
				sequence_InstancePropertyRef(context, (InstancePropertyRef) semanticObject); 
				return; 
			case RdlPackage.INSTANCE_REF:
				if (rule == grammarAccess.getHierInstanceRefRule()) {
					sequence_HierInstanceRef(context, (InstanceRef) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getInstanceRefRule()) {
					sequence_InstanceRef(context, (InstanceRef) semanticObject); 
					return; 
				}
				else break;
			case RdlPackage.INSTANTIATION:
				sequence_Instantiation(context, (Instantiation) semanticObject); 
				return; 
			case RdlPackage.POST_PROPERTY_ASSIGNMENT:
				sequence_PostPropertyAssignment(context, (PostPropertyAssignment) semanticObject); 
				return; 
			case RdlPackage.PROPERTY_ASSIGNMENT_RHS:
				sequence_PropertyAssignmentRhs(context, (PropertyAssignmentRhs) semanticObject); 
				return; 
			case RdlPackage.PROPERTY_DEFAULT:
				sequence_PropertyDefault(context, (PropertyDefault) semanticObject); 
				return; 
			case RdlPackage.PROPERTY_DEFINITION:
				sequence_PropertyDefinition(context, (PropertyDefinition) semanticObject); 
				return; 
			case RdlPackage.PROPERTY_USAGE:
				sequence_PropertyUsage(context, (PropertyUsage) semanticObject); 
				return; 
			case RdlPackage.RVALUE:
				sequence_PropertyRvalueConstant(context, (RValue) semanticObject); 
				return; 
			case RdlPackage.RANGE:
				sequence_Range(context, (Range) semanticObject); 
				return; 
			case RdlPackage.ROOT:
				sequence_Root(context, (Root) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ComponentDefinition returns ComponentDefinition
	 *
	 * Constraint:
	 *     (
	 *         type=ComponentDefinitionType 
	 *         name=ID? 
	 *         (componentDefinitions+=ComponentDefinition | instantiations+=Instantiation | propertyAssignments+=PropertyAssignment | enumDefinitions+=EnumDefinition)*
	 *     )
	 */
	protected void sequence_ComponentDefinition(ISerializationContext context, ComponentDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ComponentInstance returns ComponentInstance
	 *     Entity returns ComponentInstance
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         range=Range? 
	 *         reset=NUM? 
	 *         address=NUM? 
	 *         addrInc=NUM? 
	 *         addrMod=NUM?
	 *     )
	 */
	protected void sequence_ComponentInstance(ISerializationContext context, ComponentInstance semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConcatElem returns ConcatElem
	 *
	 * Constraint:
	 *     (instPropRef=InstancePropertyRef | value=NUM)
	 */
	protected void sequence_ConcatElem(ISerializationContext context, ConcatElem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Concat returns Concat
	 *
	 * Constraint:
	 *     (elements+=ConcatElem elements+=ConcatElem*)
	 */
	protected void sequence_Concat(ISerializationContext context, Concat semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumBody returns EnumBody
	 *
	 * Constraint:
	 *     entries+=EnumEntry*
	 */
	protected void sequence_EnumBody(ISerializationContext context, EnumBody semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Entity returns EnumDefinition
	 *     EnumDefinition returns EnumDefinition
	 *
	 * Constraint:
	 *     (name=ID body=EnumBody)
	 */
	protected void sequence_EnumDefinition(ISerializationContext context, EnumDefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RdlPackage.Literals.ENTITY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RdlPackage.Literals.ENTITY__NAME));
			if (transientValues.isValueTransient(semanticObject, RdlPackage.Literals.ENUM_DEFINITION__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RdlPackage.Literals.ENUM_DEFINITION__BODY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEnumDefinitionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEnumDefinitionAccess().getBodyEnumBodyParserRuleCall_2_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     EnumEntry returns EnumEntry
	 *
	 * Constraint:
	 *     (name=ID index=NUM properties+=EnumProperty*)
	 */
	protected void sequence_EnumEntry(ISerializationContext context, EnumEntry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumInstanceType returns EnumInstanceType
	 *
	 * Constraint:
	 *     (EXTERNAL='external' | INTERNAL='internal')
	 */
	protected void sequence_EnumInstanceType(ISerializationContext context, EnumInstanceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EnumProperty returns EnumProperty
	 *
	 * Constraint:
	 *     ((name='name' value=STR) | (name='desc' value=STR))
	 */
	protected void sequence_EnumProperty(ISerializationContext context, EnumProperty semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyAssignment returns ExplicitPropertyAssignment
	 *     DefaultProperyAssignment returns ExplicitPropertyAssignment
	 *     ExplicitPropertyAssignment returns ExplicitPropertyAssignment
	 *
	 * Constraint:
	 *     ((modifier=PropertyModifier name=Property) | (name=Property rhs=PropertyAssignmentRhs?))
	 */
	protected void sequence_ExplicitPropertyAssignment(ISerializationContext context, ExplicitPropertyAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     HierInstanceRef returns InstanceRef
	 *
	 * Constraint:
	 *     (instance=[ComponentInstance|ID] tail=HierInstanceRef?)
	 */
	protected void sequence_HierInstanceRef(ISerializationContext context, InstanceRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Include returns Include
	 *
	 * Constraint:
	 *     importURI=STR
	 */
	protected void sequence_Include(ISerializationContext context, Include semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RdlPackage.Literals.INCLUDE__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RdlPackage.Literals.INCLUDE__IMPORT_URI));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIncludeAccess().getImportURISTRTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     InstancePropertyRef returns InstancePropertyRef
	 *
	 * Constraint:
	 *     (instance=InstanceRef (propertyEnum=Property | property=[PropertyDefinition|ID])?)
	 */
	protected void sequence_InstancePropertyRef(ISerializationContext context, InstancePropertyRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     InstanceRef returns InstanceRef
	 *
	 * Constraint:
	 *     (instance=[Entity|ID] tail=HierInstanceRef?)
	 */
	protected void sequence_InstanceRef(ISerializationContext context, InstanceRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Instantiation returns Instantiation
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             (instanceType=EnumInstanceType? alias=ID? componentRef=[ComponentDefinition|ID]) | 
	 *             (component=ComponentDefinition instanceType=EnumInstanceType?)
	 *         ) 
	 *         componentInstances+=ComponentInstance 
	 *         componentInstances+=ComponentInstance*
	 *     )
	 */
	protected void sequence_Instantiation(ISerializationContext context, Instantiation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyAssignment returns PostPropertyAssignment
	 *     PostPropertyAssignment returns PostPropertyAssignment
	 *
	 * Constraint:
	 *     (
	 *         ((instance=HierInstanceRef (propertyEnum=Property | property=[PropertyDefinition|ID])) | property=[PropertyDefinition|ID]) 
	 *         rhs=PropertyAssignmentRhs?
	 *     )
	 */
	protected void sequence_PostPropertyAssignment(ISerializationContext context, PostPropertyAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyAssignmentRhs returns PropertyAssignmentRhs
	 *
	 * Constraint:
	 *     (value=PropertyRvalueConstant | instPropRef=InstancePropertyRef | (enumRef=[EnumDefinition|ID] enums=EnumBody) | elements=Concat)
	 */
	protected void sequence_PropertyAssignmentRhs(ISerializationContext context, PropertyAssignmentRhs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyDefault returns PropertyDefault
	 *
	 * Constraint:
	 *     (string=STR | value=NUM | string='true' | string='false')
	 */
	protected void sequence_PropertyDefault(ISerializationContext context, PropertyDefault semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyDefinition returns PropertyDefinition
	 *     Entity returns PropertyDefinition
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (
	 *             (type=PropertyTypeName ((usage=PropertyUsage default=PropertyDefault?) | (default=PropertyDefault usage=PropertyUsage))) | 
	 *             (usage=PropertyUsage ((type=PropertyTypeName default=PropertyDefault?) | (default=PropertyDefault type=PropertyTypeName))) | 
	 *             (default=PropertyDefault ((type=PropertyTypeName usage=PropertyUsage) | (usage=PropertyUsage type=PropertyTypeName)))
	 *         )
	 *     )
	 */
	protected void sequence_PropertyDefinition(ISerializationContext context, PropertyDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyRvalueConstant returns RValue
	 *
	 * Constraint:
	 *     (val=RValueConstant | num=NUM | str=STR)
	 */
	protected void sequence_PropertyRvalueConstant(ISerializationContext context, RValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PropertyUsage returns PropertyUsage
	 *
	 * Constraint:
	 *     (components+=PropertyComponent components+=PropertyComponent*)
	 */
	protected void sequence_PropertyUsage(ISerializationContext context, PropertyUsage semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Range returns Range
	 *
	 * Constraint:
	 *     ((left=NUM right=NUM) | size=NUM)
	 */
	protected void sequence_Range(ISerializationContext context, Range semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Root returns Root
	 *
	 * Constraint:
	 *     (
	 *         includes+=Include | 
	 *         componentDefinitions+=ComponentDefinition | 
	 *         enumDefinitions+=EnumDefinition | 
	 *         instantiations+=Instantiation | 
	 *         propertyAssignments+=PropertyAssignment | 
	 *         propertyDefinitions+=PropertyDefinition
	 *     )+
	 */
	protected void sequence_Root(ISerializationContext context, Root semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
