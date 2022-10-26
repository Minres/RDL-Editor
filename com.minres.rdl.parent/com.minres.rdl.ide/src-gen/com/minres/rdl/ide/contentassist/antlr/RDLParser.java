/*
 * generated by Xtext 2.26.0
 */
package com.minres.rdl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.minres.rdl.ide.contentassist.antlr.internal.InternalRDLParser;
import com.minres.rdl.services.RDLGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class RDLParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(RDLGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, RDLGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getRootAccess().getAlternatives(), "rule__Root__Alternatives");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_3(), "rule__PropertyDefinition__Alternatives_3");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_3_0_4(), "rule__PropertyDefinition__Alternatives_3_0_4");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_3_1_1(), "rule__PropertyDefinition__Alternatives_3_1_1");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getAlternatives_3_2_1(), "rule__PropertyDefinition__Alternatives_3_2_1");
			builder.put(grammarAccess.getPropertyDefaultAccess().getAlternatives_2(), "rule__PropertyDefault__Alternatives_2");
			builder.put(grammarAccess.getComponentDefinitionAccess().getAlternatives_3(), "rule__ComponentDefinition__Alternatives_3");
			builder.put(grammarAccess.getInstantiationAccess().getAlternatives_0(), "rule__Instantiation__Alternatives_0");
			builder.put(grammarAccess.getRangeAccess().getAlternatives_1(), "rule__Range__Alternatives_1");
			builder.put(grammarAccess.getPropertyAssignmentAccess().getAlternatives(), "rule__PropertyAssignment__Alternatives");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getAlternatives(), "rule__ExplicitPropertyAssignment__Alternatives");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getAlternatives_0(), "rule__PostPropertyAssignment__Alternatives_0");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getAlternatives_0_0_2(), "rule__PostPropertyAssignment__Alternatives_0_0_2");
			builder.put(grammarAccess.getInstancePropertyRefAccess().getAlternatives_1_1(), "rule__InstancePropertyRef__Alternatives_1_1");
			builder.put(grammarAccess.getEntityAccess().getAlternatives(), "rule__Entity__Alternatives");
			builder.put(grammarAccess.getPropertyAssignmentRhsAccess().getAlternatives(), "rule__PropertyAssignmentRhs__Alternatives");
			builder.put(grammarAccess.getConcatElemAccess().getAlternatives(), "rule__ConcatElem__Alternatives");
			builder.put(grammarAccess.getPropertyRvalueConstantAccess().getAlternatives(), "rule__PropertyRvalueConstant__Alternatives");
			builder.put(grammarAccess.getEnumPropertyAccess().getAlternatives_0(), "rule__EnumProperty__Alternatives_0");
			builder.put(grammarAccess.getEnumInstanceTypeAccess().getAlternatives(), "rule__EnumInstanceType__Alternatives");
			builder.put(grammarAccess.getPropertyTypeNameAccess().getAlternatives(), "rule__PropertyTypeName__Alternatives");
			builder.put(grammarAccess.getPropertyComponentAccess().getAlternatives(), "rule__PropertyComponent__Alternatives");
			builder.put(grammarAccess.getComponentDefinitionTypeAccess().getAlternatives(), "rule__ComponentDefinitionType__Alternatives");
			builder.put(grammarAccess.getPropertyEnumAccess().getAlternatives(), "rule__PropertyEnum__Alternatives");
			builder.put(grammarAccess.getPropertyAccess().getAlternatives(), "rule__Property__Alternatives");
			builder.put(grammarAccess.getRValueConstantAccess().getAlternatives(), "rule__RValueConstant__Alternatives");
			builder.put(grammarAccess.getPropertyModifierAccess().getAlternatives(), "rule__PropertyModifier__Alternatives");
			builder.put(grammarAccess.getRootAccess().getGroup_1(), "rule__Root__Group_1__0");
			builder.put(grammarAccess.getRootAccess().getGroup_2(), "rule__Root__Group_2__0");
			builder.put(grammarAccess.getRootAccess().getGroup_3(), "rule__Root__Group_3__0");
			builder.put(grammarAccess.getRootAccess().getGroup_4(), "rule__Root__Group_4__0");
			builder.put(grammarAccess.getRootAccess().getGroup_5(), "rule__Root__Group_5__0");
			builder.put(grammarAccess.getIncludeAccess().getGroup(), "rule__Include__Group__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup(), "rule__PropertyDefinition__Group__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_0(), "rule__PropertyDefinition__Group_3_0__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_0_4_0(), "rule__PropertyDefinition__Group_3_0_4_0__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_0_4_1(), "rule__PropertyDefinition__Group_3_0_4_1__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_1(), "rule__PropertyDefinition__Group_3_1__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_1_1_0(), "rule__PropertyDefinition__Group_3_1_1_0__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_1_1_1(), "rule__PropertyDefinition__Group_3_1_1_1__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_2(), "rule__PropertyDefinition__Group_3_2__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_2_1_0(), "rule__PropertyDefinition__Group_3_2_1_0__0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getGroup_3_2_1_1(), "rule__PropertyDefinition__Group_3_2_1_1__0");
			builder.put(grammarAccess.getPropertyDefaultAccess().getGroup(), "rule__PropertyDefault__Group__0");
			builder.put(grammarAccess.getPropertyUsageAccess().getGroup(), "rule__PropertyUsage__Group__0");
			builder.put(grammarAccess.getPropertyUsageAccess().getGroup_3(), "rule__PropertyUsage__Group_3__0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getGroup(), "rule__ComponentDefinition__Group__0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getGroup_3_0(), "rule__ComponentDefinition__Group_3_0__0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getGroup_3_1(), "rule__ComponentDefinition__Group_3_1__0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getGroup_3_2(), "rule__ComponentDefinition__Group_3_2__0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getGroup_3_3(), "rule__ComponentDefinition__Group_3_3__0");
			builder.put(grammarAccess.getInstantiationAccess().getGroup(), "rule__Instantiation__Group__0");
			builder.put(grammarAccess.getInstantiationAccess().getGroup_0_0(), "rule__Instantiation__Group_0_0__0");
			builder.put(grammarAccess.getInstantiationAccess().getGroup_0_0_1(), "rule__Instantiation__Group_0_0_1__0");
			builder.put(grammarAccess.getInstantiationAccess().getGroup_0_1(), "rule__Instantiation__Group_0_1__0");
			builder.put(grammarAccess.getInstantiationAccess().getGroup_2(), "rule__Instantiation__Group_2__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup(), "rule__ComponentInstance__Group__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_2(), "rule__ComponentInstance__Group_2__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_3(), "rule__ComponentInstance__Group_3__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_4(), "rule__ComponentInstance__Group_4__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_5(), "rule__ComponentInstance__Group_5__0");
			builder.put(grammarAccess.getRangeAccess().getGroup(), "rule__Range__Group__0");
			builder.put(grammarAccess.getRangeAccess().getGroup_1_0(), "rule__Range__Group_1_0__0");
			builder.put(grammarAccess.getDefaultProperyAssignmentAccess().getGroup(), "rule__DefaultProperyAssignment__Group__0");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getGroup_0(), "rule__ExplicitPropertyAssignment__Group_0__0");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getGroup_1(), "rule__ExplicitPropertyAssignment__Group_1__0");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getGroup_1_1(), "rule__ExplicitPropertyAssignment__Group_1_1__0");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getGroup(), "rule__PostPropertyAssignment__Group__0");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getGroup_0_0(), "rule__PostPropertyAssignment__Group_0_0__0");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getGroup_1(), "rule__PostPropertyAssignment__Group_1__0");
			builder.put(grammarAccess.getInstancePropertyRefAccess().getGroup(), "rule__InstancePropertyRef__Group__0");
			builder.put(grammarAccess.getInstancePropertyRefAccess().getGroup_1(), "rule__InstancePropertyRef__Group_1__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup(), "rule__InstanceRef__Group__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup_1(), "rule__InstanceRef__Group_1__0");
			builder.put(grammarAccess.getHierInstanceRefAccess().getGroup(), "rule__HierInstanceRef__Group__0");
			builder.put(grammarAccess.getHierInstanceRefAccess().getGroup_1(), "rule__HierInstanceRef__Group_1__0");
			builder.put(grammarAccess.getPropertyAssignmentRhsAccess().getGroup_2(), "rule__PropertyAssignmentRhs__Group_2__0");
			builder.put(grammarAccess.getConcatAccess().getGroup(), "rule__Concat__Group__0");
			builder.put(grammarAccess.getConcatAccess().getGroup_2(), "rule__Concat__Group_2__0");
			builder.put(grammarAccess.getEnumDefinitionAccess().getGroup(), "rule__EnumDefinition__Group__0");
			builder.put(grammarAccess.getEnumBodyAccess().getGroup(), "rule__EnumBody__Group__0");
			builder.put(grammarAccess.getEnumEntryAccess().getGroup(), "rule__EnumEntry__Group__0");
			builder.put(grammarAccess.getEnumEntryAccess().getGroup_3(), "rule__EnumEntry__Group_3__0");
			builder.put(grammarAccess.getEnumPropertyAccess().getGroup(), "rule__EnumProperty__Group__0");
			builder.put(grammarAccess.getEnumPropertyAccess().getGroup_0_0(), "rule__EnumProperty__Group_0_0__0");
			builder.put(grammarAccess.getEnumPropertyAccess().getGroup_0_1(), "rule__EnumProperty__Group_0_1__0");
			builder.put(grammarAccess.getRootAccess().getIncludesAssignment_0(), "rule__Root__IncludesAssignment_0");
			builder.put(grammarAccess.getRootAccess().getComponentDefinitionsAssignment_1_0(), "rule__Root__ComponentDefinitionsAssignment_1_0");
			builder.put(grammarAccess.getRootAccess().getEnumDefinitionsAssignment_2_0(), "rule__Root__EnumDefinitionsAssignment_2_0");
			builder.put(grammarAccess.getRootAccess().getInstantiationsAssignment_3_0(), "rule__Root__InstantiationsAssignment_3_0");
			builder.put(grammarAccess.getRootAccess().getPropertyAssignmentsAssignment_4_0(), "rule__Root__PropertyAssignmentsAssignment_4_0");
			builder.put(grammarAccess.getRootAccess().getPropertyDefinitionsAssignment_5_0(), "rule__Root__PropertyDefinitionsAssignment_5_0");
			builder.put(grammarAccess.getIncludeAccess().getImportURIAssignment_1(), "rule__Include__ImportURIAssignment_1");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getNameAssignment_1(), "rule__PropertyDefinition__NameAssignment_1");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_3_0_2(), "rule__PropertyDefinition__TypeAssignment_3_0_2");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getUsageAssignment_3_0_4_0_0(), "rule__PropertyDefinition__UsageAssignment_3_0_4_0_0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getDefaultAssignment_3_0_4_0_1(), "rule__PropertyDefinition__DefaultAssignment_3_0_4_0_1");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getDefaultAssignment_3_0_4_1_0(), "rule__PropertyDefinition__DefaultAssignment_3_0_4_1_0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getUsageAssignment_3_0_4_1_1(), "rule__PropertyDefinition__UsageAssignment_3_0_4_1_1");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getUsageAssignment_3_1_0(), "rule__PropertyDefinition__UsageAssignment_3_1_0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_3_1_1_0_2(), "rule__PropertyDefinition__TypeAssignment_3_1_1_0_2");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getDefaultAssignment_3_1_1_0_4(), "rule__PropertyDefinition__DefaultAssignment_3_1_1_0_4");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getDefaultAssignment_3_1_1_1_0(), "rule__PropertyDefinition__DefaultAssignment_3_1_1_1_0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_3_1_1_1_3(), "rule__PropertyDefinition__TypeAssignment_3_1_1_1_3");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getDefaultAssignment_3_2_0(), "rule__PropertyDefinition__DefaultAssignment_3_2_0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_3_2_1_0_2(), "rule__PropertyDefinition__TypeAssignment_3_2_1_0_2");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getUsageAssignment_3_2_1_0_4(), "rule__PropertyDefinition__UsageAssignment_3_2_1_0_4");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getUsageAssignment_3_2_1_1_0(), "rule__PropertyDefinition__UsageAssignment_3_2_1_1_0");
			builder.put(grammarAccess.getPropertyDefinitionAccess().getTypeAssignment_3_2_1_1_3(), "rule__PropertyDefinition__TypeAssignment_3_2_1_1_3");
			builder.put(grammarAccess.getPropertyDefaultAccess().getStringAssignment_2_0(), "rule__PropertyDefault__StringAssignment_2_0");
			builder.put(grammarAccess.getPropertyDefaultAccess().getValueAssignment_2_1(), "rule__PropertyDefault__ValueAssignment_2_1");
			builder.put(grammarAccess.getPropertyDefaultAccess().getStringAssignment_2_2(), "rule__PropertyDefault__StringAssignment_2_2");
			builder.put(grammarAccess.getPropertyDefaultAccess().getStringAssignment_2_3(), "rule__PropertyDefault__StringAssignment_2_3");
			builder.put(grammarAccess.getPropertyUsageAccess().getComponentsAssignment_2(), "rule__PropertyUsage__ComponentsAssignment_2");
			builder.put(grammarAccess.getPropertyUsageAccess().getComponentsAssignment_3_1(), "rule__PropertyUsage__ComponentsAssignment_3_1");
			builder.put(grammarAccess.getComponentDefinitionAccess().getTypeAssignment_0(), "rule__ComponentDefinition__TypeAssignment_0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getNameAssignment_1(), "rule__ComponentDefinition__NameAssignment_1");
			builder.put(grammarAccess.getComponentDefinitionAccess().getComponentDefinitionsAssignment_3_0_0(), "rule__ComponentDefinition__ComponentDefinitionsAssignment_3_0_0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getInstantiationsAssignment_3_1_0(), "rule__ComponentDefinition__InstantiationsAssignment_3_1_0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getPropertyAssignmentsAssignment_3_2_0(), "rule__ComponentDefinition__PropertyAssignmentsAssignment_3_2_0");
			builder.put(grammarAccess.getComponentDefinitionAccess().getEnumDefinitionsAssignment_3_3_0(), "rule__ComponentDefinition__EnumDefinitionsAssignment_3_3_0");
			builder.put(grammarAccess.getInstantiationAccess().getInstanceTypeAssignment_0_0_0(), "rule__Instantiation__InstanceTypeAssignment_0_0_0");
			builder.put(grammarAccess.getInstantiationAccess().getAliasAssignment_0_0_1_1(), "rule__Instantiation__AliasAssignment_0_0_1_1");
			builder.put(grammarAccess.getInstantiationAccess().getComponentRefAssignment_0_0_2(), "rule__Instantiation__ComponentRefAssignment_0_0_2");
			builder.put(grammarAccess.getInstantiationAccess().getComponentAssignment_0_1_0(), "rule__Instantiation__ComponentAssignment_0_1_0");
			builder.put(grammarAccess.getInstantiationAccess().getInstanceTypeAssignment_0_1_1(), "rule__Instantiation__InstanceTypeAssignment_0_1_1");
			builder.put(grammarAccess.getInstantiationAccess().getComponentInstancesAssignment_1(), "rule__Instantiation__ComponentInstancesAssignment_1");
			builder.put(grammarAccess.getInstantiationAccess().getComponentInstancesAssignment_2_1(), "rule__Instantiation__ComponentInstancesAssignment_2_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getNameAssignment_0(), "rule__ComponentInstance__NameAssignment_0");
			builder.put(grammarAccess.getComponentInstanceAccess().getRangeAssignment_1(), "rule__ComponentInstance__RangeAssignment_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getResetAssignment_2_1(), "rule__ComponentInstance__ResetAssignment_2_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getAddressAssignment_3_1(), "rule__ComponentInstance__AddressAssignment_3_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getAddrIncAssignment_4_1(), "rule__ComponentInstance__AddrIncAssignment_4_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getAddrModAssignment_5_1(), "rule__ComponentInstance__AddrModAssignment_5_1");
			builder.put(grammarAccess.getRangeAccess().getLeftAssignment_1_0_0(), "rule__Range__LeftAssignment_1_0_0");
			builder.put(grammarAccess.getRangeAccess().getRightAssignment_1_0_2(), "rule__Range__RightAssignment_1_0_2");
			builder.put(grammarAccess.getRangeAccess().getSizeAssignment_1_1(), "rule__Range__SizeAssignment_1_1");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getModifierAssignment_0_0(), "rule__ExplicitPropertyAssignment__ModifierAssignment_0_0");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getNameAssignment_0_1(), "rule__ExplicitPropertyAssignment__NameAssignment_0_1");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getNameAssignment_1_0(), "rule__ExplicitPropertyAssignment__NameAssignment_1_0");
			builder.put(grammarAccess.getExplicitPropertyAssignmentAccess().getRhsAssignment_1_1_1(), "rule__ExplicitPropertyAssignment__RhsAssignment_1_1_1");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getInstanceAssignment_0_0_0(), "rule__PostPropertyAssignment__InstanceAssignment_0_0_0");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getPropertyEnumAssignment_0_0_2_0(), "rule__PostPropertyAssignment__PropertyEnumAssignment_0_0_2_0");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getPropertyAssignment_0_0_2_1(), "rule__PostPropertyAssignment__PropertyAssignment_0_0_2_1");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getPropertyAssignment_0_1(), "rule__PostPropertyAssignment__PropertyAssignment_0_1");
			builder.put(grammarAccess.getPostPropertyAssignmentAccess().getRhsAssignment_1_1(), "rule__PostPropertyAssignment__RhsAssignment_1_1");
			builder.put(grammarAccess.getInstancePropertyRefAccess().getInstanceAssignment_0(), "rule__InstancePropertyRef__InstanceAssignment_0");
			builder.put(grammarAccess.getInstancePropertyRefAccess().getPropertyEnumAssignment_1_1_0(), "rule__InstancePropertyRef__PropertyEnumAssignment_1_1_0");
			builder.put(grammarAccess.getInstancePropertyRefAccess().getPropertyAssignment_1_1_1(), "rule__InstancePropertyRef__PropertyAssignment_1_1_1");
			builder.put(grammarAccess.getInstanceRefAccess().getInstanceAssignment_0(), "rule__InstanceRef__InstanceAssignment_0");
			builder.put(grammarAccess.getInstanceRefAccess().getTailAssignment_1_1(), "rule__InstanceRef__TailAssignment_1_1");
			builder.put(grammarAccess.getHierInstanceRefAccess().getInstanceAssignment_0(), "rule__HierInstanceRef__InstanceAssignment_0");
			builder.put(grammarAccess.getHierInstanceRefAccess().getTailAssignment_1_1(), "rule__HierInstanceRef__TailAssignment_1_1");
			builder.put(grammarAccess.getPropertyAssignmentRhsAccess().getValueAssignment_0(), "rule__PropertyAssignmentRhs__ValueAssignment_0");
			builder.put(grammarAccess.getPropertyAssignmentRhsAccess().getInstPropRefAssignment_1(), "rule__PropertyAssignmentRhs__InstPropRefAssignment_1");
			builder.put(grammarAccess.getPropertyAssignmentRhsAccess().getEnumRefAssignment_2_0(), "rule__PropertyAssignmentRhs__EnumRefAssignment_2_0");
			builder.put(grammarAccess.getPropertyAssignmentRhsAccess().getEnumsAssignment_2_2(), "rule__PropertyAssignmentRhs__EnumsAssignment_2_2");
			builder.put(grammarAccess.getPropertyAssignmentRhsAccess().getElementsAssignment_3(), "rule__PropertyAssignmentRhs__ElementsAssignment_3");
			builder.put(grammarAccess.getConcatAccess().getElementsAssignment_1(), "rule__Concat__ElementsAssignment_1");
			builder.put(grammarAccess.getConcatAccess().getElementsAssignment_2_1(), "rule__Concat__ElementsAssignment_2_1");
			builder.put(grammarAccess.getConcatElemAccess().getInstPropRefAssignment_0(), "rule__ConcatElem__InstPropRefAssignment_0");
			builder.put(grammarAccess.getConcatElemAccess().getValueAssignment_1(), "rule__ConcatElem__ValueAssignment_1");
			builder.put(grammarAccess.getPropertyRvalueConstantAccess().getValAssignment_0(), "rule__PropertyRvalueConstant__ValAssignment_0");
			builder.put(grammarAccess.getPropertyRvalueConstantAccess().getNumAssignment_1(), "rule__PropertyRvalueConstant__NumAssignment_1");
			builder.put(grammarAccess.getPropertyRvalueConstantAccess().getStrAssignment_2(), "rule__PropertyRvalueConstant__StrAssignment_2");
			builder.put(grammarAccess.getEnumDefinitionAccess().getNameAssignment_1(), "rule__EnumDefinition__NameAssignment_1");
			builder.put(grammarAccess.getEnumDefinitionAccess().getBodyAssignment_2(), "rule__EnumDefinition__BodyAssignment_2");
			builder.put(grammarAccess.getEnumBodyAccess().getEntriesAssignment_2(), "rule__EnumBody__EntriesAssignment_2");
			builder.put(grammarAccess.getEnumEntryAccess().getNameAssignment_0(), "rule__EnumEntry__NameAssignment_0");
			builder.put(grammarAccess.getEnumEntryAccess().getIndexAssignment_2(), "rule__EnumEntry__IndexAssignment_2");
			builder.put(grammarAccess.getEnumEntryAccess().getPropertiesAssignment_3_1(), "rule__EnumEntry__PropertiesAssignment_3_1");
			builder.put(grammarAccess.getEnumPropertyAccess().getNameAssignment_0_0_0(), "rule__EnumProperty__NameAssignment_0_0_0");
			builder.put(grammarAccess.getEnumPropertyAccess().getValueAssignment_0_0_2(), "rule__EnumProperty__ValueAssignment_0_0_2");
			builder.put(grammarAccess.getEnumPropertyAccess().getNameAssignment_0_1_0(), "rule__EnumProperty__NameAssignment_0_1_0");
			builder.put(grammarAccess.getEnumPropertyAccess().getValueAssignment_0_1_2(), "rule__EnumProperty__ValueAssignment_0_1_2");
			builder.put(grammarAccess.getEnumInstanceTypeAccess().getEXTERNALAssignment_0(), "rule__EnumInstanceType__EXTERNALAssignment_0");
			builder.put(grammarAccess.getEnumInstanceTypeAccess().getINTERNALAssignment_1(), "rule__EnumInstanceType__INTERNALAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private RDLGrammarAccess grammarAccess;

	@Override
	protected InternalRDLParser createParser() {
		InternalRDLParser result = new InternalRDLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ESCAPE_JSP", "RULE_ESCAPE_ORDL" };
	}

	public RDLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RDLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
