package com.minres.rdl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.minres.rdl.services.RDLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalRDLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STR", "RULE_ID", "RULE_NUM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ESCAPE_JSP", "RULE_ESCAPE_ORDL", "';'", "'`include'", "'property'", "'{'", "'type'", "'='", "'}'", "'default'", "'true'", "'false'", "'component'", "'|'", "'alias'", "','", "'@'", "'+='", "'%='", "'['", "':'", "']'", "'->'", "'.'", "'enum'", "'name'", "'desc'", "'external'", "'internal'", "'string'", "'number'", "'boolean'", "'addrmap'", "'reg'", "'regfile'", "'field'", "'ref'", "'signal'", "'all'", "'arbiter'", "'rset'", "'rclr'", "'woclr'", "'woset'", "'we'", "'wel'", "'swwe'", "'swwel'", "'hwset'", "'hwclr'", "'swmod'", "'swacc'", "'sticky'", "'stickybit'", "'intr'", "'anded'", "'ored'", "'xored'", "'counter'", "'overflow'", "'sharedextbus'", "'errextbus'", "'reset'", "'littleendian'", "'bigendian'", "'rsvdset'", "'rsvdsetX'", "'bridge'", "'shared'", "'msb0'", "'lsb0'", "'sync'", "'async'", "'cpuif_reset'", "'field_reset'", "'activehigh'", "'activelow'", "'singlepulse'", "'underflow'", "'incr'", "'decr'", "'incrwidth'", "'decrwidth'", "'incrvalue'", "'decrvalue'", "'saturate'", "'decrsaturate'", "'threshold'", "'decrthreshold'", "'dontcompare'", "'donttest'", "'alignment'", "'regwidth'", "'fieldwidth'", "'signalwidth'", "'accesswidth'", "'sw'", "'hw'", "'addressing'", "'precedence'", "'encode'", "'resetsignal'", "'clock'", "'mask'", "'enable'", "'hwenable'", "'hwmask'", "'haltmask'", "'haltenable'", "'halt'", "'next'", "'UNDEFINED'", "'rw'", "'wr'", "'r'", "'w'", "'na'", "'compact'", "'regalign'", "'fullalign'", "'posedge'", "'negedge'", "'bothedge'", "'level'", "'nonsticky'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_STR=4;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int RULE_NUM=6;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_ESCAPE_ORDL=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int RULE_ESCAPE_JSP=10;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=7;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalRDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRDLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRDL.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private RDLGrammarAccess grammarAccess;

        public InternalRDLParser(TokenStream input, RDLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Root";
       	}

       	@Override
       	protected RDLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRoot"
    // InternalRDL.g:71:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalRDL.g:71:45: (iv_ruleRoot= ruleRoot EOF )
            // InternalRDL.g:72:2: iv_ruleRoot= ruleRoot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRootRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoot; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // InternalRDL.g:78:1: ruleRoot returns [EObject current=null] : ( ( (lv_includes_0_0= ruleInclude ) ) | ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' ) | ( ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';' ) )* ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_includes_0_0 = null;

        EObject lv_componentDefinitions_1_0 = null;

        EObject lv_enumDefinitions_3_0 = null;

        EObject lv_instantiations_5_0 = null;

        EObject lv_propertyAssignments_7_0 = null;

        EObject lv_propertyDefinitions_9_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:84:2: ( ( ( (lv_includes_0_0= ruleInclude ) ) | ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' ) | ( ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';' ) )* )
            // InternalRDL.g:85:2: ( ( (lv_includes_0_0= ruleInclude ) ) | ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' ) | ( ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';' ) )*
            {
            // InternalRDL.g:85:2: ( ( (lv_includes_0_0= ruleInclude ) ) | ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' ) | ( ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';' ) )*
            loop1:
            do {
                int alt1=7;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalRDL.g:86:3: ( (lv_includes_0_0= ruleInclude ) )
            	    {
            	    // InternalRDL.g:86:3: ( (lv_includes_0_0= ruleInclude ) )
            	    // InternalRDL.g:87:4: (lv_includes_0_0= ruleInclude )
            	    {
            	    // InternalRDL.g:87:4: (lv_includes_0_0= ruleInclude )
            	    // InternalRDL.g:88:5: lv_includes_0_0= ruleInclude
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRootAccess().getIncludesIncludeParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_includes_0_0=ruleInclude();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRootRule());
            	      					}
            	      					add(
            	      						current,
            	      						"includes",
            	      						lv_includes_0_0,
            	      						"com.minres.rdl.RDL.Include");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRDL.g:106:3: ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' )
            	    {
            	    // InternalRDL.g:106:3: ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' )
            	    // InternalRDL.g:107:4: ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';'
            	    {
            	    // InternalRDL.g:107:4: ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) )
            	    // InternalRDL.g:108:5: (lv_componentDefinitions_1_0= ruleComponentDefinition )
            	    {
            	    // InternalRDL.g:108:5: (lv_componentDefinitions_1_0= ruleComponentDefinition )
            	    // InternalRDL.g:109:6: lv_componentDefinitions_1_0= ruleComponentDefinition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRootAccess().getComponentDefinitionsComponentDefinitionParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_componentDefinitions_1_0=ruleComponentDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRootRule());
            	      						}
            	      						add(
            	      							current,
            	      							"componentDefinitions",
            	      							lv_componentDefinitions_1_0,
            	      							"com.minres.rdl.RDL.ComponentDefinition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getRootAccess().getSemicolonKeyword_1_1());
            	      			
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRDL.g:132:3: ( ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';' )
            	    {
            	    // InternalRDL.g:132:3: ( ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';' )
            	    // InternalRDL.g:133:4: ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';'
            	    {
            	    // InternalRDL.g:133:4: ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) )
            	    // InternalRDL.g:134:5: (lv_enumDefinitions_3_0= ruleEnumDefinition )
            	    {
            	    // InternalRDL.g:134:5: (lv_enumDefinitions_3_0= ruleEnumDefinition )
            	    // InternalRDL.g:135:6: lv_enumDefinitions_3_0= ruleEnumDefinition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRootAccess().getEnumDefinitionsEnumDefinitionParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_enumDefinitions_3_0=ruleEnumDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRootRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumDefinitions",
            	      							lv_enumDefinitions_3_0,
            	      							"com.minres.rdl.RDL.EnumDefinition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_4=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getRootAccess().getSemicolonKeyword_2_1());
            	      			
            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRDL.g:158:3: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
            	    {
            	    // InternalRDL.g:158:3: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
            	    // InternalRDL.g:159:4: ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';'
            	    {
            	    // InternalRDL.g:159:4: ( (lv_instantiations_5_0= ruleInstantiation ) )
            	    // InternalRDL.g:160:5: (lv_instantiations_5_0= ruleInstantiation )
            	    {
            	    // InternalRDL.g:160:5: (lv_instantiations_5_0= ruleInstantiation )
            	    // InternalRDL.g:161:6: lv_instantiations_5_0= ruleInstantiation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRootAccess().getInstantiationsInstantiationParserRuleCall_3_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_instantiations_5_0=ruleInstantiation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRootRule());
            	      						}
            	      						add(
            	      							current,
            	      							"instantiations",
            	      							lv_instantiations_5_0,
            	      							"com.minres.rdl.RDL.Instantiation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_6=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getRootAccess().getSemicolonKeyword_3_1());
            	      			
            	    }

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRDL.g:184:3: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
            	    {
            	    // InternalRDL.g:184:3: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
            	    // InternalRDL.g:185:4: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';'
            	    {
            	    // InternalRDL.g:185:4: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) )
            	    // InternalRDL.g:186:5: (lv_propertyAssignments_7_0= rulePropertyAssignment )
            	    {
            	    // InternalRDL.g:186:5: (lv_propertyAssignments_7_0= rulePropertyAssignment )
            	    // InternalRDL.g:187:6: lv_propertyAssignments_7_0= rulePropertyAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRootAccess().getPropertyAssignmentsPropertyAssignmentParserRuleCall_4_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_propertyAssignments_7_0=rulePropertyAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRootRule());
            	      						}
            	      						add(
            	      							current,
            	      							"propertyAssignments",
            	      							lv_propertyAssignments_7_0,
            	      							"com.minres.rdl.RDL.PropertyAssignment");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_8=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_8, grammarAccess.getRootAccess().getSemicolonKeyword_4_1());
            	      			
            	    }

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRDL.g:210:3: ( ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';' )
            	    {
            	    // InternalRDL.g:210:3: ( ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';' )
            	    // InternalRDL.g:211:4: ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';'
            	    {
            	    // InternalRDL.g:211:4: ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) )
            	    // InternalRDL.g:212:5: (lv_propertyDefinitions_9_0= rulePropertyDefinition )
            	    {
            	    // InternalRDL.g:212:5: (lv_propertyDefinitions_9_0= rulePropertyDefinition )
            	    // InternalRDL.g:213:6: lv_propertyDefinitions_9_0= rulePropertyDefinition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRootAccess().getPropertyDefinitionsPropertyDefinitionParserRuleCall_5_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_propertyDefinitions_9_0=rulePropertyDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRootRule());
            	      						}
            	      						add(
            	      							current,
            	      							"propertyDefinitions",
            	      							lv_propertyDefinitions_9_0,
            	      							"com.minres.rdl.RDL.PropertyDefinition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,12,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_10, grammarAccess.getRootAccess().getSemicolonKeyword_5_1());
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleInclude"
    // InternalRDL.g:239:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalRDL.g:239:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalRDL.g:240:2: iv_ruleInclude= ruleInclude EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInclude=ruleInclude();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInclude; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInclude"


    // $ANTLR start "ruleInclude"
    // InternalRDL.g:246:1: ruleInclude returns [EObject current=null] : (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;


        	enterRule();

        try {
            // InternalRDL.g:252:2: ( (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) ) )
            // InternalRDL.g:253:2: (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) )
            {
            // InternalRDL.g:253:2: (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) )
            // InternalRDL.g:254:3: otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIncludeAccess().getIncludeKeyword_0());
              		
            }
            // InternalRDL.g:258:3: ( (lv_importURI_1_0= RULE_STR ) )
            // InternalRDL.g:259:4: (lv_importURI_1_0= RULE_STR )
            {
            // InternalRDL.g:259:4: (lv_importURI_1_0= RULE_STR )
            // InternalRDL.g:260:5: lv_importURI_1_0= RULE_STR
            {
            lv_importURI_1_0=(Token)match(input,RULE_STR,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_importURI_1_0, grammarAccess.getIncludeAccess().getImportURISTRTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIncludeRule());
              					}
              					setWithLastConsumed(
              						current,
              						"importURI",
              						lv_importURI_1_0,
              						"com.minres.rdl.RDL.STR");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInclude"


    // $ANTLR start "entryRulePropertyDefinition"
    // InternalRDL.g:280:1: entryRulePropertyDefinition returns [EObject current=null] : iv_rulePropertyDefinition= rulePropertyDefinition EOF ;
    public final EObject entryRulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDefinition = null;


        try {
            // InternalRDL.g:280:59: (iv_rulePropertyDefinition= rulePropertyDefinition EOF )
            // InternalRDL.g:281:2: iv_rulePropertyDefinition= rulePropertyDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyDefinition=rulePropertyDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyDefinition"


    // $ANTLR start "rulePropertyDefinition"
    // InternalRDL.g:287:1: rulePropertyDefinition returns [EObject current=null] : (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' ) ;
    public final EObject rulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Enumerator lv_type_5_0 = null;

        EObject lv_usage_7_0 = null;

        EObject lv_default_8_0 = null;

        EObject lv_default_9_0 = null;

        EObject lv_usage_10_0 = null;

        EObject lv_usage_11_0 = null;

        Enumerator lv_type_14_0 = null;

        EObject lv_default_16_0 = null;

        EObject lv_default_17_0 = null;

        Enumerator lv_type_20_0 = null;

        EObject lv_default_22_0 = null;

        Enumerator lv_type_25_0 = null;

        EObject lv_usage_27_0 = null;

        EObject lv_usage_28_0 = null;

        Enumerator lv_type_31_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:293:2: ( (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' ) )
            // InternalRDL.g:294:2: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' )
            {
            // InternalRDL.g:294:2: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' )
            // InternalRDL.g:295:3: otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyDefinitionAccess().getPropertyKeyword_0());
              		
            }
            // InternalRDL.g:299:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRDL.g:300:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRDL.g:300:4: (lv_name_1_0= RULE_ID )
            // InternalRDL.g:301:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPropertyDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"com.minres.rdl.RDL.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPropertyDefinitionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalRDL.g:321:3: ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt7=1;
                }
                break;
            case 22:
                {
                alt7=2;
                }
                break;
            case 19:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalRDL.g:322:4: (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) )
                    {
                    // InternalRDL.g:322:4: (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) )
                    // InternalRDL.g:323:5: otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) )
                    {
                    otherlv_3=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_0_0());
                      				
                    }
                    otherlv_4=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_0_1());
                      				
                    }
                    // InternalRDL.g:331:5: ( (lv_type_5_0= rulePropertyTypeName ) )
                    // InternalRDL.g:332:6: (lv_type_5_0= rulePropertyTypeName )
                    {
                    // InternalRDL.g:332:6: (lv_type_5_0= rulePropertyTypeName )
                    // InternalRDL.g:333:7: lv_type_5_0= rulePropertyTypeName
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_0_2_0());
                      						
                    }
                    pushFollow(FOLLOW_4);
                    lv_type_5_0=rulePropertyTypeName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                      							}
                      							set(
                      								current,
                      								"type",
                      								lv_type_5_0,
                      								"com.minres.rdl.RDL.PropertyTypeName");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,12,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_0_3());
                      				
                    }
                    // InternalRDL.g:354:5: ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==22) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==19) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalRDL.g:355:6: ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? )
                            {
                            // InternalRDL.g:355:6: ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? )
                            // InternalRDL.g:356:7: ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )?
                            {
                            // InternalRDL.g:356:7: ( (lv_usage_7_0= rulePropertyUsage ) )
                            // InternalRDL.g:357:8: (lv_usage_7_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:357:8: (lv_usage_7_0= rulePropertyUsage )
                            // InternalRDL.g:358:9: lv_usage_7_0= rulePropertyUsage
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_0_4_0_0_0());
                              								
                            }
                            pushFollow(FOLLOW_12);
                            lv_usage_7_0=rulePropertyUsage();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"usage",
                              										lv_usage_7_0,
                              										"com.minres.rdl.RDL.PropertyUsage");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalRDL.g:375:7: ( (lv_default_8_0= rulePropertyDefault ) )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0==19) ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // InternalRDL.g:376:8: (lv_default_8_0= rulePropertyDefault )
                                    {
                                    // InternalRDL.g:376:8: (lv_default_8_0= rulePropertyDefault )
                                    // InternalRDL.g:377:9: lv_default_8_0= rulePropertyDefault
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_0_4_0_1_0());
                                      								
                                    }
                                    pushFollow(FOLLOW_13);
                                    lv_default_8_0=rulePropertyDefault();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                                      									}
                                      									set(
                                      										current,
                                      										"default",
                                      										lv_default_8_0,
                                      										"com.minres.rdl.RDL.PropertyDefault");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRDL.g:396:6: ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) )
                            {
                            // InternalRDL.g:396:6: ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) )
                            // InternalRDL.g:397:7: ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) )
                            {
                            // InternalRDL.g:397:7: ( (lv_default_9_0= rulePropertyDefault ) )
                            // InternalRDL.g:398:8: (lv_default_9_0= rulePropertyDefault )
                            {
                            // InternalRDL.g:398:8: (lv_default_9_0= rulePropertyDefault )
                            // InternalRDL.g:399:9: lv_default_9_0= rulePropertyDefault
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_0_4_1_0_0());
                              								
                            }
                            pushFollow(FOLLOW_14);
                            lv_default_9_0=rulePropertyDefault();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"default",
                              										lv_default_9_0,
                              										"com.minres.rdl.RDL.PropertyDefault");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            // InternalRDL.g:416:7: ( (lv_usage_10_0= rulePropertyUsage ) )
                            // InternalRDL.g:417:8: (lv_usage_10_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:417:8: (lv_usage_10_0= rulePropertyUsage )
                            // InternalRDL.g:418:9: lv_usage_10_0= rulePropertyUsage
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_0_4_1_1_0());
                              								
                            }
                            pushFollow(FOLLOW_13);
                            lv_usage_10_0=rulePropertyUsage();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"usage",
                              										lv_usage_10_0,
                              										"com.minres.rdl.RDL.PropertyUsage");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:439:4: ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) )
                    {
                    // InternalRDL.g:439:4: ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) )
                    // InternalRDL.g:440:5: ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) )
                    {
                    // InternalRDL.g:440:5: ( (lv_usage_11_0= rulePropertyUsage ) )
                    // InternalRDL.g:441:6: (lv_usage_11_0= rulePropertyUsage )
                    {
                    // InternalRDL.g:441:6: (lv_usage_11_0= rulePropertyUsage )
                    // InternalRDL.g:442:7: lv_usage_11_0= rulePropertyUsage
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_9);
                    lv_usage_11_0=rulePropertyUsage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                      							}
                      							set(
                      								current,
                      								"usage",
                      								lv_usage_11_0,
                      								"com.minres.rdl.RDL.PropertyUsage");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalRDL.g:459:5: ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==16) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==19) ) {
                        alt5=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalRDL.g:460:6: (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? )
                            {
                            // InternalRDL.g:460:6: (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? )
                            // InternalRDL.g:461:7: otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )?
                            {
                            otherlv_12=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_12, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_1_1_0_0());
                              						
                            }
                            otherlv_13=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_13, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_1_1_0_1());
                              						
                            }
                            // InternalRDL.g:469:7: ( (lv_type_14_0= rulePropertyTypeName ) )
                            // InternalRDL.g:470:8: (lv_type_14_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:470:8: (lv_type_14_0= rulePropertyTypeName )
                            // InternalRDL.g:471:9: lv_type_14_0= rulePropertyTypeName
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_1_1_0_2_0());
                              								
                            }
                            pushFollow(FOLLOW_4);
                            lv_type_14_0=rulePropertyTypeName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"type",
                              										lv_type_14_0,
                              										"com.minres.rdl.RDL.PropertyTypeName");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_15=(Token)match(input,12,FOLLOW_12); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_15, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_1_1_0_3());
                              						
                            }
                            // InternalRDL.g:492:7: ( (lv_default_16_0= rulePropertyDefault ) )?
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==19) ) {
                                alt4=1;
                            }
                            switch (alt4) {
                                case 1 :
                                    // InternalRDL.g:493:8: (lv_default_16_0= rulePropertyDefault )
                                    {
                                    // InternalRDL.g:493:8: (lv_default_16_0= rulePropertyDefault )
                                    // InternalRDL.g:494:9: lv_default_16_0= rulePropertyDefault
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_1_1_0_4_0());
                                      								
                                    }
                                    pushFollow(FOLLOW_13);
                                    lv_default_16_0=rulePropertyDefault();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                                      									}
                                      									set(
                                      										current,
                                      										"default",
                                      										lv_default_16_0,
                                      										"com.minres.rdl.RDL.PropertyDefault");
                                      									afterParserOrEnumRuleCall();
                                      								
                                    }

                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRDL.g:513:6: ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' )
                            {
                            // InternalRDL.g:513:6: ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' )
                            // InternalRDL.g:514:7: ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';'
                            {
                            // InternalRDL.g:514:7: ( (lv_default_17_0= rulePropertyDefault ) )
                            // InternalRDL.g:515:8: (lv_default_17_0= rulePropertyDefault )
                            {
                            // InternalRDL.g:515:8: (lv_default_17_0= rulePropertyDefault )
                            // InternalRDL.g:516:9: lv_default_17_0= rulePropertyDefault
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_1_1_1_0_0());
                              								
                            }
                            pushFollow(FOLLOW_15);
                            lv_default_17_0=rulePropertyDefault();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"default",
                              										lv_default_17_0,
                              										"com.minres.rdl.RDL.PropertyDefault");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_18=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_18, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_1_1_1_1());
                              						
                            }
                            otherlv_19=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_19, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_1_1_1_2());
                              						
                            }
                            // InternalRDL.g:541:7: ( (lv_type_20_0= rulePropertyTypeName ) )
                            // InternalRDL.g:542:8: (lv_type_20_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:542:8: (lv_type_20_0= rulePropertyTypeName )
                            // InternalRDL.g:543:9: lv_type_20_0= rulePropertyTypeName
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_1_1_1_3_0());
                              								
                            }
                            pushFollow(FOLLOW_4);
                            lv_type_20_0=rulePropertyTypeName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"type",
                              										lv_type_20_0,
                              										"com.minres.rdl.RDL.PropertyTypeName");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_21=(Token)match(input,12,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_21, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_1_1_1_4());
                              						
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:568:4: ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) )
                    {
                    // InternalRDL.g:568:4: ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) )
                    // InternalRDL.g:569:5: ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) )
                    {
                    // InternalRDL.g:569:5: ( (lv_default_22_0= rulePropertyDefault ) )
                    // InternalRDL.g:570:6: (lv_default_22_0= rulePropertyDefault )
                    {
                    // InternalRDL.g:570:6: (lv_default_22_0= rulePropertyDefault )
                    // InternalRDL.g:571:7: lv_default_22_0= rulePropertyDefault
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_2_0_0());
                      						
                    }
                    pushFollow(FOLLOW_16);
                    lv_default_22_0=rulePropertyDefault();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                      							}
                      							set(
                      								current,
                      								"default",
                      								lv_default_22_0,
                      								"com.minres.rdl.RDL.PropertyDefault");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalRDL.g:588:5: ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==16) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==22) ) {
                        alt6=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalRDL.g:589:6: (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) )
                            {
                            // InternalRDL.g:589:6: (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) )
                            // InternalRDL.g:590:7: otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) )
                            {
                            otherlv_23=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_23, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_2_1_0_0());
                              						
                            }
                            otherlv_24=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_24, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_2_1_0_1());
                              						
                            }
                            // InternalRDL.g:598:7: ( (lv_type_25_0= rulePropertyTypeName ) )
                            // InternalRDL.g:599:8: (lv_type_25_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:599:8: (lv_type_25_0= rulePropertyTypeName )
                            // InternalRDL.g:600:9: lv_type_25_0= rulePropertyTypeName
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_2_1_0_2_0());
                              								
                            }
                            pushFollow(FOLLOW_4);
                            lv_type_25_0=rulePropertyTypeName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"type",
                              										lv_type_25_0,
                              										"com.minres.rdl.RDL.PropertyTypeName");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_26=(Token)match(input,12,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_26, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_2_1_0_3());
                              						
                            }
                            // InternalRDL.g:621:7: ( (lv_usage_27_0= rulePropertyUsage ) )
                            // InternalRDL.g:622:8: (lv_usage_27_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:622:8: (lv_usage_27_0= rulePropertyUsage )
                            // InternalRDL.g:623:9: lv_usage_27_0= rulePropertyUsage
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_2_1_0_4_0());
                              								
                            }
                            pushFollow(FOLLOW_13);
                            lv_usage_27_0=rulePropertyUsage();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"usage",
                              										lv_usage_27_0,
                              										"com.minres.rdl.RDL.PropertyUsage");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRDL.g:642:6: ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' )
                            {
                            // InternalRDL.g:642:6: ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' )
                            // InternalRDL.g:643:7: ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';'
                            {
                            // InternalRDL.g:643:7: ( (lv_usage_28_0= rulePropertyUsage ) )
                            // InternalRDL.g:644:8: (lv_usage_28_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:644:8: (lv_usage_28_0= rulePropertyUsage )
                            // InternalRDL.g:645:9: lv_usage_28_0= rulePropertyUsage
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_2_1_1_0_0());
                              								
                            }
                            pushFollow(FOLLOW_15);
                            lv_usage_28_0=rulePropertyUsage();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"usage",
                              										lv_usage_28_0,
                              										"com.minres.rdl.RDL.PropertyUsage");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_29=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_29, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_2_1_1_1());
                              						
                            }
                            otherlv_30=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_30, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_2_1_1_2());
                              						
                            }
                            // InternalRDL.g:670:7: ( (lv_type_31_0= rulePropertyTypeName ) )
                            // InternalRDL.g:671:8: (lv_type_31_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:671:8: (lv_type_31_0= rulePropertyTypeName )
                            // InternalRDL.g:672:9: lv_type_31_0= rulePropertyTypeName
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_2_1_1_3_0());
                              								
                            }
                            pushFollow(FOLLOW_4);
                            lv_type_31_0=rulePropertyTypeName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                              									}
                              									set(
                              										current,
                              										"type",
                              										lv_type_31_0,
                              										"com.minres.rdl.RDL.PropertyTypeName");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_32=(Token)match(input,12,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_32, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_2_1_1_4());
                              						
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_33=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_33, grammarAccess.getPropertyDefinitionAccess().getRightCurlyBracketKeyword_4());
              		
            }
            otherlv_34=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_34, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyDefinition"


    // $ANTLR start "entryRulePropertyDefault"
    // InternalRDL.g:709:1: entryRulePropertyDefault returns [EObject current=null] : iv_rulePropertyDefault= rulePropertyDefault EOF ;
    public final EObject entryRulePropertyDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDefault = null;


        try {
            // InternalRDL.g:709:56: (iv_rulePropertyDefault= rulePropertyDefault EOF )
            // InternalRDL.g:710:2: iv_rulePropertyDefault= rulePropertyDefault EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyDefaultRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyDefault=rulePropertyDefault();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyDefault; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyDefault"


    // $ANTLR start "rulePropertyDefault"
    // InternalRDL.g:716:1: rulePropertyDefault returns [EObject current=null] : (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' ) ;
    public final EObject rulePropertyDefault() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_string_2_0=null;
        Token lv_value_3_0=null;
        Token lv_string_4_0=null;
        Token lv_string_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalRDL.g:722:2: ( (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' ) )
            // InternalRDL.g:723:2: (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' )
            {
            // InternalRDL.g:723:2: (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' )
            // InternalRDL.g:724:3: otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyDefaultAccess().getDefaultKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,17,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPropertyDefaultAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalRDL.g:732:3: ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_STR:
                {
                alt8=1;
                }
                break;
            case RULE_NUM:
                {
                alt8=2;
                }
                break;
            case 20:
                {
                alt8=3;
                }
                break;
            case 21:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalRDL.g:733:4: ( (lv_string_2_0= RULE_STR ) )
                    {
                    // InternalRDL.g:733:4: ( (lv_string_2_0= RULE_STR ) )
                    // InternalRDL.g:734:5: (lv_string_2_0= RULE_STR )
                    {
                    // InternalRDL.g:734:5: (lv_string_2_0= RULE_STR )
                    // InternalRDL.g:735:6: lv_string_2_0= RULE_STR
                    {
                    lv_string_2_0=(Token)match(input,RULE_STR,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_string_2_0, grammarAccess.getPropertyDefaultAccess().getStringSTRTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyDefaultRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"string",
                      							lv_string_2_0,
                      							"com.minres.rdl.RDL.STR");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:752:4: ( (lv_value_3_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:752:4: ( (lv_value_3_0= RULE_NUM ) )
                    // InternalRDL.g:753:5: (lv_value_3_0= RULE_NUM )
                    {
                    // InternalRDL.g:753:5: (lv_value_3_0= RULE_NUM )
                    // InternalRDL.g:754:6: lv_value_3_0= RULE_NUM
                    {
                    lv_value_3_0=(Token)match(input,RULE_NUM,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_0, grammarAccess.getPropertyDefaultAccess().getValueNUMTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyDefaultRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"com.minres.rdl.RDL.NUM");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:771:4: ( (lv_string_4_0= 'true' ) )
                    {
                    // InternalRDL.g:771:4: ( (lv_string_4_0= 'true' ) )
                    // InternalRDL.g:772:5: (lv_string_4_0= 'true' )
                    {
                    // InternalRDL.g:772:5: (lv_string_4_0= 'true' )
                    // InternalRDL.g:773:6: lv_string_4_0= 'true'
                    {
                    lv_string_4_0=(Token)match(input,20,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_string_4_0, grammarAccess.getPropertyDefaultAccess().getStringTrueKeyword_2_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyDefaultRule());
                      						}
                      						setWithLastConsumed(current, "string", lv_string_4_0, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:786:4: ( (lv_string_5_0= 'false' ) )
                    {
                    // InternalRDL.g:786:4: ( (lv_string_5_0= 'false' ) )
                    // InternalRDL.g:787:5: (lv_string_5_0= 'false' )
                    {
                    // InternalRDL.g:787:5: (lv_string_5_0= 'false' )
                    // InternalRDL.g:788:6: lv_string_5_0= 'false'
                    {
                    lv_string_5_0=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_string_5_0, grammarAccess.getPropertyDefaultAccess().getStringFalseKeyword_2_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyDefaultRule());
                      						}
                      						setWithLastConsumed(current, "string", lv_string_5_0, "false");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getPropertyDefaultAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyDefault"


    // $ANTLR start "entryRulePropertyUsage"
    // InternalRDL.g:809:1: entryRulePropertyUsage returns [EObject current=null] : iv_rulePropertyUsage= rulePropertyUsage EOF ;
    public final EObject entryRulePropertyUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyUsage = null;


        try {
            // InternalRDL.g:809:54: (iv_rulePropertyUsage= rulePropertyUsage EOF )
            // InternalRDL.g:810:2: iv_rulePropertyUsage= rulePropertyUsage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyUsageRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyUsage=rulePropertyUsage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyUsage; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyUsage"


    // $ANTLR start "rulePropertyUsage"
    // InternalRDL.g:816:1: rulePropertyUsage returns [EObject current=null] : (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' ) ;
    public final EObject rulePropertyUsage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_components_2_0 = null;

        Enumerator lv_components_4_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:822:2: ( (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' ) )
            // InternalRDL.g:823:2: (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' )
            {
            // InternalRDL.g:823:2: (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' )
            // InternalRDL.g:824:3: otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyUsageAccess().getComponentKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPropertyUsageAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalRDL.g:832:3: ( (lv_components_2_0= rulePropertyComponent ) )
            // InternalRDL.g:833:4: (lv_components_2_0= rulePropertyComponent )
            {
            // InternalRDL.g:833:4: (lv_components_2_0= rulePropertyComponent )
            // InternalRDL.g:834:5: lv_components_2_0= rulePropertyComponent
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyUsageAccess().getComponentsPropertyComponentEnumRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_components_2_0=rulePropertyComponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPropertyUsageRule());
              					}
              					add(
              						current,
              						"components",
              						lv_components_2_0,
              						"com.minres.rdl.RDL.PropertyComponent");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRDL.g:851:3: (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalRDL.g:852:4: otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getPropertyUsageAccess().getVerticalLineKeyword_3_0());
            	      			
            	    }
            	    // InternalRDL.g:856:4: ( (lv_components_4_0= rulePropertyComponent ) )
            	    // InternalRDL.g:857:5: (lv_components_4_0= rulePropertyComponent )
            	    {
            	    // InternalRDL.g:857:5: (lv_components_4_0= rulePropertyComponent )
            	    // InternalRDL.g:858:6: lv_components_4_0= rulePropertyComponent
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPropertyUsageAccess().getComponentsPropertyComponentEnumRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_components_4_0=rulePropertyComponent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPropertyUsageRule());
            	      						}
            	      						add(
            	      							current,
            	      							"components",
            	      							lv_components_4_0,
            	      							"com.minres.rdl.RDL.PropertyComponent");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_5=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPropertyUsageAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyUsage"


    // $ANTLR start "entryRuleComponentDefinition"
    // InternalRDL.g:884:1: entryRuleComponentDefinition returns [EObject current=null] : iv_ruleComponentDefinition= ruleComponentDefinition EOF ;
    public final EObject entryRuleComponentDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentDefinition = null;


        try {
            // InternalRDL.g:884:60: (iv_ruleComponentDefinition= ruleComponentDefinition EOF )
            // InternalRDL.g:885:2: iv_ruleComponentDefinition= ruleComponentDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComponentDefinition=ruleComponentDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentDefinition"


    // $ANTLR start "ruleComponentDefinition"
    // InternalRDL.g:891:1: ruleComponentDefinition returns [EObject current=null] : ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' ) )* otherlv_11= '}' ) ;
    public final EObject ruleComponentDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_componentDefinitions_3_0 = null;

        EObject lv_instantiations_5_0 = null;

        EObject lv_propertyAssignments_7_0 = null;

        EObject lv_enumDefinitions_9_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:897:2: ( ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' ) )* otherlv_11= '}' ) )
            // InternalRDL.g:898:2: ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' ) )* otherlv_11= '}' )
            {
            // InternalRDL.g:898:2: ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' ) )* otherlv_11= '}' )
            // InternalRDL.g:899:3: ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' ) )* otherlv_11= '}'
            {
            // InternalRDL.g:899:3: ( (lv_type_0_0= ruleComponentDefinitionType ) )
            // InternalRDL.g:900:4: (lv_type_0_0= ruleComponentDefinitionType )
            {
            // InternalRDL.g:900:4: (lv_type_0_0= ruleComponentDefinitionType )
            // InternalRDL.g:901:5: lv_type_0_0= ruleComponentDefinitionType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComponentDefinitionAccess().getTypeComponentDefinitionTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_20);
            lv_type_0_0=ruleComponentDefinitionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"com.minres.rdl.RDL.ComponentDefinitionType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRDL.g:918:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRDL.g:919:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRDL.g:919:4: (lv_name_1_0= RULE_ID )
                    // InternalRDL.g:920:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_1_0, grammarAccess.getComponentDefinitionAccess().getNameIDTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getComponentDefinitionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_1_0,
                      						"com.minres.rdl.RDL.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getComponentDefinitionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalRDL.g:940:3: ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' ) )*
            loop11:
            do {
                int alt11=5;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // InternalRDL.g:941:4: ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' )
            	    {
            	    // InternalRDL.g:941:4: ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' )
            	    // InternalRDL.g:942:5: ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';'
            	    {
            	    // InternalRDL.g:942:5: ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) )
            	    // InternalRDL.g:943:6: (lv_componentDefinitions_3_0= ruleComponentDefinition )
            	    {
            	    // InternalRDL.g:943:6: (lv_componentDefinitions_3_0= ruleComponentDefinition )
            	    // InternalRDL.g:944:7: lv_componentDefinitions_3_0= ruleComponentDefinition
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getComponentDefinitionAccess().getComponentDefinitionsComponentDefinitionParserRuleCall_3_0_0_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_componentDefinitions_3_0=ruleComponentDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
            	      							}
            	      							add(
            	      								current,
            	      								"componentDefinitions",
            	      								lv_componentDefinitions_3_0,
            	      								"com.minres.rdl.RDL.ComponentDefinition");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    otherlv_4=(Token)match(input,12,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_4, grammarAccess.getComponentDefinitionAccess().getSemicolonKeyword_3_0_1());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRDL.g:967:4: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
            	    {
            	    // InternalRDL.g:967:4: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
            	    // InternalRDL.g:968:5: ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';'
            	    {
            	    // InternalRDL.g:968:5: ( (lv_instantiations_5_0= ruleInstantiation ) )
            	    // InternalRDL.g:969:6: (lv_instantiations_5_0= ruleInstantiation )
            	    {
            	    // InternalRDL.g:969:6: (lv_instantiations_5_0= ruleInstantiation )
            	    // InternalRDL.g:970:7: lv_instantiations_5_0= ruleInstantiation
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getComponentDefinitionAccess().getInstantiationsInstantiationParserRuleCall_3_1_0_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_instantiations_5_0=ruleInstantiation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
            	      							}
            	      							add(
            	      								current,
            	      								"instantiations",
            	      								lv_instantiations_5_0,
            	      								"com.minres.rdl.RDL.Instantiation");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    otherlv_6=(Token)match(input,12,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getComponentDefinitionAccess().getSemicolonKeyword_3_1_1());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRDL.g:993:4: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
            	    {
            	    // InternalRDL.g:993:4: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
            	    // InternalRDL.g:994:5: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';'
            	    {
            	    // InternalRDL.g:994:5: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) )
            	    // InternalRDL.g:995:6: (lv_propertyAssignments_7_0= rulePropertyAssignment )
            	    {
            	    // InternalRDL.g:995:6: (lv_propertyAssignments_7_0= rulePropertyAssignment )
            	    // InternalRDL.g:996:7: lv_propertyAssignments_7_0= rulePropertyAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getComponentDefinitionAccess().getPropertyAssignmentsPropertyAssignmentParserRuleCall_3_2_0_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_propertyAssignments_7_0=rulePropertyAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
            	      							}
            	      							add(
            	      								current,
            	      								"propertyAssignments",
            	      								lv_propertyAssignments_7_0,
            	      								"com.minres.rdl.RDL.PropertyAssignment");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    otherlv_8=(Token)match(input,12,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_8, grammarAccess.getComponentDefinitionAccess().getSemicolonKeyword_3_2_1());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRDL.g:1019:4: ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' )
            	    {
            	    // InternalRDL.g:1019:4: ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' )
            	    // InternalRDL.g:1020:5: ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';'
            	    {
            	    // InternalRDL.g:1020:5: ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) )
            	    // InternalRDL.g:1021:6: (lv_enumDefinitions_9_0= ruleEnumDefinition )
            	    {
            	    // InternalRDL.g:1021:6: (lv_enumDefinitions_9_0= ruleEnumDefinition )
            	    // InternalRDL.g:1022:7: lv_enumDefinitions_9_0= ruleEnumDefinition
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getComponentDefinitionAccess().getEnumDefinitionsEnumDefinitionParserRuleCall_3_3_0_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_enumDefinitions_9_0=ruleEnumDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
            	      							}
            	      							add(
            	      								current,
            	      								"enumDefinitions",
            	      								lv_enumDefinitions_9_0,
            	      								"com.minres.rdl.RDL.EnumDefinition");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    otherlv_10=(Token)match(input,12,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getComponentDefinitionAccess().getSemicolonKeyword_3_3_1());
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_11=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getComponentDefinitionAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentDefinition"


    // $ANTLR start "entryRuleInstantiation"
    // InternalRDL.g:1053:1: entryRuleInstantiation returns [EObject current=null] : iv_ruleInstantiation= ruleInstantiation EOF ;
    public final EObject entryRuleInstantiation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiation = null;


        try {
            // InternalRDL.g:1053:54: (iv_ruleInstantiation= ruleInstantiation EOF )
            // InternalRDL.g:1054:2: iv_ruleInstantiation= ruleInstantiation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstantiationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstantiation=ruleInstantiation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstantiation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstantiation"


    // $ANTLR start "ruleInstantiation"
    // InternalRDL.g:1060:1: ruleInstantiation returns [EObject current=null] : ( ( ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) ) | ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? ) ) ( (lv_componentInstances_6_0= ruleComponentInstance ) ) (otherlv_7= ',' ( (lv_componentInstances_8_0= ruleComponentInstance ) ) )* ) ;
    public final EObject ruleInstantiation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_alias_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_instanceType_0_0 = null;

        EObject lv_component_4_0 = null;

        EObject lv_instanceType_5_0 = null;

        EObject lv_componentInstances_6_0 = null;

        EObject lv_componentInstances_8_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1066:2: ( ( ( ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) ) | ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? ) ) ( (lv_componentInstances_6_0= ruleComponentInstance ) ) (otherlv_7= ',' ( (lv_componentInstances_8_0= ruleComponentInstance ) ) )* ) )
            // InternalRDL.g:1067:2: ( ( ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) ) | ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? ) ) ( (lv_componentInstances_6_0= ruleComponentInstance ) ) (otherlv_7= ',' ( (lv_componentInstances_8_0= ruleComponentInstance ) ) )* )
            {
            // InternalRDL.g:1067:2: ( ( ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) ) | ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? ) ) ( (lv_componentInstances_6_0= ruleComponentInstance ) ) (otherlv_7= ',' ( (lv_componentInstances_8_0= ruleComponentInstance ) ) )* )
            // InternalRDL.g:1068:3: ( ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) ) | ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? ) ) ( (lv_componentInstances_6_0= ruleComponentInstance ) ) (otherlv_7= ',' ( (lv_componentInstances_8_0= ruleComponentInstance ) ) )*
            {
            // InternalRDL.g:1068:3: ( ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) ) | ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID||LA15_0==24||(LA15_0>=37 && LA15_0<=38)) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=42 && LA15_0<=45)||LA15_0==47) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalRDL.g:1069:4: ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalRDL.g:1069:4: ( ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) ) )
                    // InternalRDL.g:1070:5: ( (lv_instanceType_0_0= ruleEnumInstanceType ) )? (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalRDL.g:1070:5: ( (lv_instanceType_0_0= ruleEnumInstanceType ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=37 && LA12_0<=38)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalRDL.g:1071:6: (lv_instanceType_0_0= ruleEnumInstanceType )
                            {
                            // InternalRDL.g:1071:6: (lv_instanceType_0_0= ruleEnumInstanceType )
                            // InternalRDL.g:1072:7: lv_instanceType_0_0= ruleEnumInstanceType
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInstantiationAccess().getInstanceTypeEnumInstanceTypeParserRuleCall_0_0_0_0());
                              						
                            }
                            pushFollow(FOLLOW_22);
                            lv_instanceType_0_0=ruleEnumInstanceType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getInstantiationRule());
                              							}
                              							set(
                              								current,
                              								"instanceType",
                              								lv_instanceType_0_0,
                              								"com.minres.rdl.RDL.EnumInstanceType");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalRDL.g:1089:5: (otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==24) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalRDL.g:1090:6: otherlv_1= 'alias' ( (lv_alias_2_0= RULE_ID ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_1, grammarAccess.getInstantiationAccess().getAliasKeyword_0_0_1_0());
                              					
                            }
                            // InternalRDL.g:1094:6: ( (lv_alias_2_0= RULE_ID ) )
                            // InternalRDL.g:1095:7: (lv_alias_2_0= RULE_ID )
                            {
                            // InternalRDL.g:1095:7: (lv_alias_2_0= RULE_ID )
                            // InternalRDL.g:1096:8: lv_alias_2_0= RULE_ID
                            {
                            lv_alias_2_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_alias_2_0, grammarAccess.getInstantiationAccess().getAliasIDTerminalRuleCall_0_0_1_1_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getInstantiationRule());
                              								}
                              								setWithLastConsumed(
                              									current,
                              									"alias",
                              									lv_alias_2_0,
                              									"com.minres.rdl.RDL.ID");
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalRDL.g:1113:5: ( (otherlv_3= RULE_ID ) )
                    // InternalRDL.g:1114:6: (otherlv_3= RULE_ID )
                    {
                    // InternalRDL.g:1114:6: (otherlv_3= RULE_ID )
                    // InternalRDL.g:1115:7: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							/* */
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getInstantiationRule());
                      							}
                      						
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_3, grammarAccess.getInstantiationAccess().getComponentRefComponentDefinitionCrossReference_0_0_2_0());
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:1131:4: ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? )
                    {
                    // InternalRDL.g:1131:4: ( ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )? )
                    // InternalRDL.g:1132:5: ( (lv_component_4_0= ruleComponentDefinition ) ) ( (lv_instanceType_5_0= ruleEnumInstanceType ) )?
                    {
                    // InternalRDL.g:1132:5: ( (lv_component_4_0= ruleComponentDefinition ) )
                    // InternalRDL.g:1133:6: (lv_component_4_0= ruleComponentDefinition )
                    {
                    // InternalRDL.g:1133:6: (lv_component_4_0= ruleComponentDefinition )
                    // InternalRDL.g:1134:7: lv_component_4_0= ruleComponentDefinition
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getInstantiationAccess().getComponentComponentDefinitionParserRuleCall_0_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_23);
                    lv_component_4_0=ruleComponentDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getInstantiationRule());
                      							}
                      							set(
                      								current,
                      								"component",
                      								lv_component_4_0,
                      								"com.minres.rdl.RDL.ComponentDefinition");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalRDL.g:1151:5: ( (lv_instanceType_5_0= ruleEnumInstanceType ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=37 && LA14_0<=38)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalRDL.g:1152:6: (lv_instanceType_5_0= ruleEnumInstanceType )
                            {
                            // InternalRDL.g:1152:6: (lv_instanceType_5_0= ruleEnumInstanceType )
                            // InternalRDL.g:1153:7: lv_instanceType_5_0= ruleEnumInstanceType
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInstantiationAccess().getInstanceTypeEnumInstanceTypeParserRuleCall_0_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_7);
                            lv_instanceType_5_0=ruleEnumInstanceType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getInstantiationRule());
                              							}
                              							set(
                              								current,
                              								"instanceType",
                              								lv_instanceType_5_0,
                              								"com.minres.rdl.RDL.EnumInstanceType");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalRDL.g:1172:3: ( (lv_componentInstances_6_0= ruleComponentInstance ) )
            // InternalRDL.g:1173:4: (lv_componentInstances_6_0= ruleComponentInstance )
            {
            // InternalRDL.g:1173:4: (lv_componentInstances_6_0= ruleComponentInstance )
            // InternalRDL.g:1174:5: lv_componentInstances_6_0= ruleComponentInstance
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInstantiationAccess().getComponentInstancesComponentInstanceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_componentInstances_6_0=ruleComponentInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInstantiationRule());
              					}
              					add(
              						current,
              						"componentInstances",
              						lv_componentInstances_6_0,
              						"com.minres.rdl.RDL.ComponentInstance");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRDL.g:1191:3: (otherlv_7= ',' ( (lv_componentInstances_8_0= ruleComponentInstance ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalRDL.g:1192:4: otherlv_7= ',' ( (lv_componentInstances_8_0= ruleComponentInstance ) )
            	    {
            	    otherlv_7=(Token)match(input,25,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_7, grammarAccess.getInstantiationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalRDL.g:1196:4: ( (lv_componentInstances_8_0= ruleComponentInstance ) )
            	    // InternalRDL.g:1197:5: (lv_componentInstances_8_0= ruleComponentInstance )
            	    {
            	    // InternalRDL.g:1197:5: (lv_componentInstances_8_0= ruleComponentInstance )
            	    // InternalRDL.g:1198:6: lv_componentInstances_8_0= ruleComponentInstance
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getInstantiationAccess().getComponentInstancesComponentInstanceParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_componentInstances_8_0=ruleComponentInstance();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getInstantiationRule());
            	      						}
            	      						add(
            	      							current,
            	      							"componentInstances",
            	      							lv_componentInstances_8_0,
            	      							"com.minres.rdl.RDL.ComponentInstance");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstantiation"


    // $ANTLR start "entryRuleComponentInstance"
    // InternalRDL.g:1220:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // InternalRDL.g:1220:58: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // InternalRDL.g:1221:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentInstance; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentInstance"


    // $ANTLR start "ruleComponentInstance"
    // InternalRDL.g:1227:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? ) ;
    public final EObject ruleComponentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_reset_3_0=null;
        Token otherlv_4=null;
        Token lv_address_5_0=null;
        Token otherlv_6=null;
        Token lv_addrInc_7_0=null;
        Token otherlv_8=null;
        Token lv_addrMod_9_0=null;
        EObject lv_range_1_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1233:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? ) )
            // InternalRDL.g:1234:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? )
            {
            // InternalRDL.g:1234:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? )
            // InternalRDL.g:1235:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )?
            {
            // InternalRDL.g:1235:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRDL.g:1236:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRDL.g:1236:4: (lv_name_0_0= RULE_ID )
            // InternalRDL.g:1237:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getComponentInstanceRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.rdl.RDL.ID");
              				
            }

            }


            }

            // InternalRDL.g:1253:3: ( (lv_range_1_0= ruleRange ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRDL.g:1254:4: (lv_range_1_0= ruleRange )
                    {
                    // InternalRDL.g:1254:4: (lv_range_1_0= ruleRange )
                    // InternalRDL.g:1255:5: lv_range_1_0= ruleRange
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getComponentInstanceAccess().getRangeRangeParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_26);
                    lv_range_1_0=ruleRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                      					}
                      					set(
                      						current,
                      						"range",
                      						lv_range_1_0,
                      						"com.minres.rdl.RDL.Range");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRDL.g:1272:3: (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==17) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRDL.g:1273:4: otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getComponentInstanceAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalRDL.g:1277:4: ( (lv_reset_3_0= RULE_NUM ) )
                    // InternalRDL.g:1278:5: (lv_reset_3_0= RULE_NUM )
                    {
                    // InternalRDL.g:1278:5: (lv_reset_3_0= RULE_NUM )
                    // InternalRDL.g:1279:6: lv_reset_3_0= RULE_NUM
                    {
                    lv_reset_3_0=(Token)match(input,RULE_NUM,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_reset_3_0, grammarAccess.getComponentInstanceAccess().getResetNUMTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getComponentInstanceRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"reset",
                      							lv_reset_3_0,
                      							"com.minres.rdl.RDL.NUM");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRDL.g:1296:3: (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==26) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRDL.g:1297:4: otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) )
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getComponentInstanceAccess().getCommercialAtKeyword_3_0());
                      			
                    }
                    // InternalRDL.g:1301:4: ( (lv_address_5_0= RULE_NUM ) )
                    // InternalRDL.g:1302:5: (lv_address_5_0= RULE_NUM )
                    {
                    // InternalRDL.g:1302:5: (lv_address_5_0= RULE_NUM )
                    // InternalRDL.g:1303:6: lv_address_5_0= RULE_NUM
                    {
                    lv_address_5_0=(Token)match(input,RULE_NUM,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_address_5_0, grammarAccess.getComponentInstanceAccess().getAddressNUMTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getComponentInstanceRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"address",
                      							lv_address_5_0,
                      							"com.minres.rdl.RDL.NUM");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRDL.g:1320:3: (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRDL.g:1321:4: otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getPlusSignEqualsSignKeyword_4_0());
                      			
                    }
                    // InternalRDL.g:1325:4: ( (lv_addrInc_7_0= RULE_NUM ) )
                    // InternalRDL.g:1326:5: (lv_addrInc_7_0= RULE_NUM )
                    {
                    // InternalRDL.g:1326:5: (lv_addrInc_7_0= RULE_NUM )
                    // InternalRDL.g:1327:6: lv_addrInc_7_0= RULE_NUM
                    {
                    lv_addrInc_7_0=(Token)match(input,RULE_NUM,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_addrInc_7_0, grammarAccess.getComponentInstanceAccess().getAddrIncNUMTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getComponentInstanceRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"addrInc",
                      							lv_addrInc_7_0,
                      							"com.minres.rdl.RDL.NUM");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRDL.g:1344:3: (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRDL.g:1345:4: otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) )
                    {
                    otherlv_8=(Token)match(input,28,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getPercentSignEqualsSignKeyword_5_0());
                      			
                    }
                    // InternalRDL.g:1349:4: ( (lv_addrMod_9_0= RULE_NUM ) )
                    // InternalRDL.g:1350:5: (lv_addrMod_9_0= RULE_NUM )
                    {
                    // InternalRDL.g:1350:5: (lv_addrMod_9_0= RULE_NUM )
                    // InternalRDL.g:1351:6: lv_addrMod_9_0= RULE_NUM
                    {
                    lv_addrMod_9_0=(Token)match(input,RULE_NUM,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_addrMod_9_0, grammarAccess.getComponentInstanceAccess().getAddrModNUMTerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getComponentInstanceRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"addrMod",
                      							lv_addrMod_9_0,
                      							"com.minres.rdl.RDL.NUM");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentInstance"


    // $ANTLR start "entryRuleRange"
    // InternalRDL.g:1372:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalRDL.g:1372:46: (iv_ruleRange= ruleRange EOF )
            // InternalRDL.g:1373:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalRDL.g:1379:1: ruleRange returns [EObject current=null] : (otherlv_0= '[' ( ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_left_1_0=null;
        Token otherlv_2=null;
        Token lv_right_3_0=null;
        Token lv_size_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRDL.g:1385:2: ( (otherlv_0= '[' ( ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' ) )
            // InternalRDL.g:1386:2: (otherlv_0= '[' ( ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' )
            {
            // InternalRDL.g:1386:2: (otherlv_0= '[' ( ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' )
            // InternalRDL.g:1387:3: otherlv_0= '[' ( ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalRDL.g:1391:3: ( ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_NUM) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==31) ) {
                    alt22=2;
                }
                else if ( (LA22_1==30) ) {
                    alt22=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalRDL.g:1392:4: ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) )
                    {
                    // InternalRDL.g:1392:4: ( ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) ) )
                    // InternalRDL.g:1393:5: ( (lv_left_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_right_3_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:1393:5: ( (lv_left_1_0= RULE_NUM ) )
                    // InternalRDL.g:1394:6: (lv_left_1_0= RULE_NUM )
                    {
                    // InternalRDL.g:1394:6: (lv_left_1_0= RULE_NUM )
                    // InternalRDL.g:1395:7: lv_left_1_0= RULE_NUM
                    {
                    lv_left_1_0=(Token)match(input,RULE_NUM,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_left_1_0, grammarAccess.getRangeAccess().getLeftNUMTerminalRuleCall_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRangeRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"left",
                      								lv_left_1_0,
                      								"com.minres.rdl.RDL.NUM");
                      						
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,30,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getColonKeyword_1_0_1());
                      				
                    }
                    // InternalRDL.g:1415:5: ( (lv_right_3_0= RULE_NUM ) )
                    // InternalRDL.g:1416:6: (lv_right_3_0= RULE_NUM )
                    {
                    // InternalRDL.g:1416:6: (lv_right_3_0= RULE_NUM )
                    // InternalRDL.g:1417:7: lv_right_3_0= RULE_NUM
                    {
                    lv_right_3_0=(Token)match(input,RULE_NUM,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_right_3_0, grammarAccess.getRangeAccess().getRightNUMTerminalRuleCall_1_0_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRangeRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"right",
                      								lv_right_3_0,
                      								"com.minres.rdl.RDL.NUM");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:1435:4: ( (lv_size_4_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:1435:4: ( (lv_size_4_0= RULE_NUM ) )
                    // InternalRDL.g:1436:5: (lv_size_4_0= RULE_NUM )
                    {
                    // InternalRDL.g:1436:5: (lv_size_4_0= RULE_NUM )
                    // InternalRDL.g:1437:6: lv_size_4_0= RULE_NUM
                    {
                    lv_size_4_0=(Token)match(input,RULE_NUM,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_size_4_0, grammarAccess.getRangeAccess().getSizeNUMTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRangeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"size",
                      							lv_size_4_0,
                      							"com.minres.rdl.RDL.NUM");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRangeAccess().getRightSquareBracketKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRulePropertyAssignment"
    // InternalRDL.g:1462:1: entryRulePropertyAssignment returns [EObject current=null] : iv_rulePropertyAssignment= rulePropertyAssignment EOF ;
    public final EObject entryRulePropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssignment = null;


        try {
            // InternalRDL.g:1462:59: (iv_rulePropertyAssignment= rulePropertyAssignment EOF )
            // InternalRDL.g:1463:2: iv_rulePropertyAssignment= rulePropertyAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyAssignment=rulePropertyAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAssignment"


    // $ANTLR start "rulePropertyAssignment"
    // InternalRDL.g:1469:1: rulePropertyAssignment returns [EObject current=null] : (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment ) ;
    public final EObject rulePropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_DefaultProperyAssignment_0 = null;

        EObject this_ExplicitPropertyAssignment_1 = null;

        EObject this_PostPropertyAssignment_2 = null;



        	enterRule();

        try {
            // InternalRDL.g:1475:2: ( (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment ) )
            // InternalRDL.g:1476:2: (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment )
            {
            // InternalRDL.g:1476:2: (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt23=1;
                }
                break;
            case 35:
            case 36:
            case 38:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
                {
                alt23=2;
                }
                break;
            case RULE_ID:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalRDL.g:1477:3: this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyAssignmentAccess().getDefaultProperyAssignmentParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DefaultProperyAssignment_0=ruleDefaultProperyAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DefaultProperyAssignment_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRDL.g:1489:3: this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyAssignmentAccess().getExplicitPropertyAssignmentParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExplicitPropertyAssignment_1=ruleExplicitPropertyAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExplicitPropertyAssignment_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRDL.g:1501:3: this_PostPropertyAssignment_2= rulePostPropertyAssignment
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPropertyAssignmentAccess().getPostPropertyAssignmentParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostPropertyAssignment_2=rulePostPropertyAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostPropertyAssignment_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyAssignment"


    // $ANTLR start "entryRuleDefaultProperyAssignment"
    // InternalRDL.g:1516:1: entryRuleDefaultProperyAssignment returns [EObject current=null] : iv_ruleDefaultProperyAssignment= ruleDefaultProperyAssignment EOF ;
    public final EObject entryRuleDefaultProperyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultProperyAssignment = null;


        try {
            // InternalRDL.g:1516:65: (iv_ruleDefaultProperyAssignment= ruleDefaultProperyAssignment EOF )
            // InternalRDL.g:1517:2: iv_ruleDefaultProperyAssignment= ruleDefaultProperyAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultProperyAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefaultProperyAssignment=ruleDefaultProperyAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultProperyAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultProperyAssignment"


    // $ANTLR start "ruleDefaultProperyAssignment"
    // InternalRDL.g:1523:1: ruleDefaultProperyAssignment returns [EObject current=null] : (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment ) ;
    public final EObject ruleDefaultProperyAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_ExplicitPropertyAssignment_1 = null;



        	enterRule();

        try {
            // InternalRDL.g:1529:2: ( (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment ) )
            // InternalRDL.g:1530:2: (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment )
            {
            // InternalRDL.g:1530:2: (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment )
            // InternalRDL.g:1531:3: otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment
            {
            otherlv_0=(Token)match(input,19,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDefaultProperyAssignmentAccess().getDefaultKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDefaultProperyAssignmentAccess().getExplicitPropertyAssignmentParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            this_ExplicitPropertyAssignment_1=ruleExplicitPropertyAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExplicitPropertyAssignment_1;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultProperyAssignment"


    // $ANTLR start "entryRuleExplicitPropertyAssignment"
    // InternalRDL.g:1550:1: entryRuleExplicitPropertyAssignment returns [EObject current=null] : iv_ruleExplicitPropertyAssignment= ruleExplicitPropertyAssignment EOF ;
    public final EObject entryRuleExplicitPropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExplicitPropertyAssignment = null;


        try {
            // InternalRDL.g:1550:67: (iv_ruleExplicitPropertyAssignment= ruleExplicitPropertyAssignment EOF )
            // InternalRDL.g:1551:2: iv_ruleExplicitPropertyAssignment= ruleExplicitPropertyAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExplicitPropertyAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExplicitPropertyAssignment=ruleExplicitPropertyAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExplicitPropertyAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExplicitPropertyAssignment"


    // $ANTLR start "ruleExplicitPropertyAssignment"
    // InternalRDL.g:1557:1: ruleExplicitPropertyAssignment returns [EObject current=null] : ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) ) | ( ( (lv_name_2_0= ruleProperty ) ) (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )? ) ) ;
    public final EObject ruleExplicitPropertyAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Enumerator lv_modifier_0_0 = null;

        Enumerator lv_name_1_0 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_rhs_4_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1563:2: ( ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) ) | ( ( (lv_name_2_0= ruleProperty ) ) (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )? ) ) )
            // InternalRDL.g:1564:2: ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) ) | ( ( (lv_name_2_0= ruleProperty ) ) (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )? ) )
            {
            // InternalRDL.g:1564:2: ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) ) | ( ( (lv_name_2_0= ruleProperty ) ) (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==121||(LA25_0>=130 && LA25_0<=134)) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=35 && LA25_0<=36)||LA25_0==38||(LA25_0>=49 && LA25_0<=120)) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalRDL.g:1565:3: ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) )
                    {
                    // InternalRDL.g:1565:3: ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) )
                    // InternalRDL.g:1566:4: ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) )
                    {
                    // InternalRDL.g:1566:4: ( (lv_modifier_0_0= rulePropertyModifier ) )
                    // InternalRDL.g:1567:5: (lv_modifier_0_0= rulePropertyModifier )
                    {
                    // InternalRDL.g:1567:5: (lv_modifier_0_0= rulePropertyModifier )
                    // InternalRDL.g:1568:6: lv_modifier_0_0= rulePropertyModifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getModifierPropertyModifierEnumRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
                    lv_modifier_0_0=rulePropertyModifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExplicitPropertyAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"modifier",
                      							lv_modifier_0_0,
                      							"com.minres.rdl.RDL.PropertyModifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRDL.g:1585:4: ( (lv_name_1_0= ruleProperty ) )
                    // InternalRDL.g:1586:5: (lv_name_1_0= ruleProperty )
                    {
                    // InternalRDL.g:1586:5: (lv_name_1_0= ruleProperty )
                    // InternalRDL.g:1587:6: lv_name_1_0= ruleProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getNamePropertyEnumRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_name_1_0=ruleProperty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExplicitPropertyAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_1_0,
                      							"com.minres.rdl.RDL.Property");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:1606:3: ( ( (lv_name_2_0= ruleProperty ) ) (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )? )
                    {
                    // InternalRDL.g:1606:3: ( ( (lv_name_2_0= ruleProperty ) ) (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )? )
                    // InternalRDL.g:1607:4: ( (lv_name_2_0= ruleProperty ) ) (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )?
                    {
                    // InternalRDL.g:1607:4: ( (lv_name_2_0= ruleProperty ) )
                    // InternalRDL.g:1608:5: (lv_name_2_0= ruleProperty )
                    {
                    // InternalRDL.g:1608:5: (lv_name_2_0= ruleProperty )
                    // InternalRDL.g:1609:6: lv_name_2_0= ruleProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getNamePropertyEnumRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
                    lv_name_2_0=ruleProperty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExplicitPropertyAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"com.minres.rdl.RDL.Property");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRDL.g:1626:4: (otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==17) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalRDL.g:1627:5: otherlv_3= '=' ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) )
                            {
                            otherlv_3=(Token)match(input,17,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getExplicitPropertyAssignmentAccess().getEqualsSignKeyword_1_1_0());
                              				
                            }
                            // InternalRDL.g:1631:5: ( (lv_rhs_4_0= rulePropertyAssignmentRhs ) )
                            // InternalRDL.g:1632:6: (lv_rhs_4_0= rulePropertyAssignmentRhs )
                            {
                            // InternalRDL.g:1632:6: (lv_rhs_4_0= rulePropertyAssignmentRhs )
                            // InternalRDL.g:1633:7: lv_rhs_4_0= rulePropertyAssignmentRhs
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getRhsPropertyAssignmentRhsParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_rhs_4_0=rulePropertyAssignmentRhs();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getExplicitPropertyAssignmentRule());
                              							}
                              							set(
                              								current,
                              								"rhs",
                              								lv_rhs_4_0,
                              								"com.minres.rdl.RDL.PropertyAssignmentRhs");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExplicitPropertyAssignment"


    // $ANTLR start "entryRulePostPropertyAssignment"
    // InternalRDL.g:1656:1: entryRulePostPropertyAssignment returns [EObject current=null] : iv_rulePostPropertyAssignment= rulePostPropertyAssignment EOF ;
    public final EObject entryRulePostPropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostPropertyAssignment = null;


        try {
            // InternalRDL.g:1656:63: (iv_rulePostPropertyAssignment= rulePostPropertyAssignment EOF )
            // InternalRDL.g:1657:2: iv_rulePostPropertyAssignment= rulePostPropertyAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostPropertyAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostPropertyAssignment=rulePostPropertyAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostPropertyAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostPropertyAssignment"


    // $ANTLR start "rulePostPropertyAssignment"
    // InternalRDL.g:1663:1: rulePostPropertyAssignment returns [EObject current=null] : ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? ) ;
    public final EObject rulePostPropertyAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_instance_0_0 = null;

        Enumerator lv_propertyEnum_2_0 = null;

        EObject lv_rhs_6_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1669:2: ( ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? ) )
            // InternalRDL.g:1670:2: ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? )
            {
            // InternalRDL.g:1670:2: ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? )
            // InternalRDL.g:1671:3: ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )?
            {
            // InternalRDL.g:1671:3: ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==EOF||LA27_1==12||LA27_1==17) ) {
                    alt27=2;
                }
                else if ( ((LA27_1>=32 && LA27_1<=33)) ) {
                    alt27=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalRDL.g:1672:4: ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )
                    {
                    // InternalRDL.g:1672:4: ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )
                    // InternalRDL.g:1673:5: ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalRDL.g:1673:5: ( (lv_instance_0_0= ruleHierInstanceRef ) )
                    // InternalRDL.g:1674:6: (lv_instance_0_0= ruleHierInstanceRef )
                    {
                    // InternalRDL.g:1674:6: (lv_instance_0_0= ruleHierInstanceRef )
                    // InternalRDL.g:1675:7: lv_instance_0_0= ruleHierInstanceRef
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPostPropertyAssignmentAccess().getInstanceHierInstanceRefParserRuleCall_0_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_36);
                    lv_instance_0_0=ruleHierInstanceRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPostPropertyAssignmentRule());
                      							}
                      							set(
                      								current,
                      								"instance",
                      								lv_instance_0_0,
                      								"com.minres.rdl.RDL.HierInstanceRef");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getPostPropertyAssignmentAccess().getHyphenMinusGreaterThanSignKeyword_0_0_1());
                      				
                    }
                    // InternalRDL.g:1696:5: ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=35 && LA26_0<=36)||LA26_0==38||(LA26_0>=49 && LA26_0<=120)) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_ID) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalRDL.g:1697:6: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            {
                            // InternalRDL.g:1697:6: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            // InternalRDL.g:1698:7: (lv_propertyEnum_2_0= ruleProperty )
                            {
                            // InternalRDL.g:1698:7: (lv_propertyEnum_2_0= ruleProperty )
                            // InternalRDL.g:1699:8: lv_propertyEnum_2_0= ruleProperty
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getPostPropertyAssignmentAccess().getPropertyEnumPropertyEnumRuleCall_0_0_2_0_0());
                              							
                            }
                            pushFollow(FOLLOW_34);
                            lv_propertyEnum_2_0=ruleProperty();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getPostPropertyAssignmentRule());
                              								}
                              								set(
                              									current,
                              									"propertyEnum",
                              									lv_propertyEnum_2_0,
                              									"com.minres.rdl.RDL.Property");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRDL.g:1717:6: ( (otherlv_3= RULE_ID ) )
                            {
                            // InternalRDL.g:1717:6: ( (otherlv_3= RULE_ID ) )
                            // InternalRDL.g:1718:7: (otherlv_3= RULE_ID )
                            {
                            // InternalRDL.g:1718:7: (otherlv_3= RULE_ID )
                            // InternalRDL.g:1719:8: otherlv_3= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              								/* */
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getPostPropertyAssignmentRule());
                              								}
                              							
                            }
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(otherlv_3, grammarAccess.getPostPropertyAssignmentAccess().getPropertyPropertyDefinitionCrossReference_0_0_2_1_0());
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:1736:4: ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalRDL.g:1736:4: ( (otherlv_4= RULE_ID ) )
                    // InternalRDL.g:1737:5: (otherlv_4= RULE_ID )
                    {
                    // InternalRDL.g:1737:5: (otherlv_4= RULE_ID )
                    // InternalRDL.g:1738:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPostPropertyAssignmentRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getPostPropertyAssignmentAccess().getPropertyPropertyDefinitionCrossReference_0_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRDL.g:1753:3: (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==17) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRDL.g:1754:4: otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getPostPropertyAssignmentAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalRDL.g:1758:4: ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) )
                    // InternalRDL.g:1759:5: (lv_rhs_6_0= rulePropertyAssignmentRhs )
                    {
                    // InternalRDL.g:1759:5: (lv_rhs_6_0= rulePropertyAssignmentRhs )
                    // InternalRDL.g:1760:6: lv_rhs_6_0= rulePropertyAssignmentRhs
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPostPropertyAssignmentAccess().getRhsPropertyAssignmentRhsParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rhs_6_0=rulePropertyAssignmentRhs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPostPropertyAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"rhs",
                      							lv_rhs_6_0,
                      							"com.minres.rdl.RDL.PropertyAssignmentRhs");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostPropertyAssignment"


    // $ANTLR start "entryRuleInstancePropertyRef"
    // InternalRDL.g:1782:1: entryRuleInstancePropertyRef returns [EObject current=null] : iv_ruleInstancePropertyRef= ruleInstancePropertyRef EOF ;
    public final EObject entryRuleInstancePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstancePropertyRef = null;


        try {
            // InternalRDL.g:1782:60: (iv_ruleInstancePropertyRef= ruleInstancePropertyRef EOF )
            // InternalRDL.g:1783:2: iv_ruleInstancePropertyRef= ruleInstancePropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstancePropertyRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstancePropertyRef=ruleInstancePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstancePropertyRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstancePropertyRef"


    // $ANTLR start "ruleInstancePropertyRef"
    // InternalRDL.g:1789:1: ruleInstancePropertyRef returns [EObject current=null] : ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? ) ;
    public final EObject ruleInstancePropertyRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_instance_0_0 = null;

        Enumerator lv_propertyEnum_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1795:2: ( ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? ) )
            // InternalRDL.g:1796:2: ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? )
            {
            // InternalRDL.g:1796:2: ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? )
            // InternalRDL.g:1797:3: ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )?
            {
            // InternalRDL.g:1797:3: ( (lv_instance_0_0= ruleInstanceRef ) )
            // InternalRDL.g:1798:4: (lv_instance_0_0= ruleInstanceRef )
            {
            // InternalRDL.g:1798:4: (lv_instance_0_0= ruleInstanceRef )
            // InternalRDL.g:1799:5: lv_instance_0_0= ruleInstanceRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInstancePropertyRefAccess().getInstanceInstanceRefParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_38);
            lv_instance_0_0=ruleInstanceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInstancePropertyRefRule());
              					}
              					set(
              						current,
              						"instance",
              						lv_instance_0_0,
              						"com.minres.rdl.RDL.InstanceRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRDL.g:1816:3: (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==32) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRDL.g:1817:4: otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInstancePropertyRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                      			
                    }
                    // InternalRDL.g:1821:4: ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=35 && LA29_0<=36)||LA29_0==38||(LA29_0>=49 && LA29_0<=120)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_ID) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalRDL.g:1822:5: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            {
                            // InternalRDL.g:1822:5: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            // InternalRDL.g:1823:6: (lv_propertyEnum_2_0= ruleProperty )
                            {
                            // InternalRDL.g:1823:6: (lv_propertyEnum_2_0= ruleProperty )
                            // InternalRDL.g:1824:7: lv_propertyEnum_2_0= ruleProperty
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getInstancePropertyRefAccess().getPropertyEnumPropertyEnumRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_propertyEnum_2_0=ruleProperty();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getInstancePropertyRefRule());
                              							}
                              							set(
                              								current,
                              								"propertyEnum",
                              								lv_propertyEnum_2_0,
                              								"com.minres.rdl.RDL.Property");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRDL.g:1842:5: ( (otherlv_3= RULE_ID ) )
                            {
                            // InternalRDL.g:1842:5: ( (otherlv_3= RULE_ID ) )
                            // InternalRDL.g:1843:6: (otherlv_3= RULE_ID )
                            {
                            // InternalRDL.g:1843:6: (otherlv_3= RULE_ID )
                            // InternalRDL.g:1844:7: otherlv_3= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              							/* */
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getInstancePropertyRefRule());
                              							}
                              						
                            }
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_3, grammarAccess.getInstancePropertyRefAccess().getPropertyPropertyDefinitionCrossReference_1_1_1_0());
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstancePropertyRef"


    // $ANTLR start "entryRuleInstanceRef"
    // InternalRDL.g:1864:1: entryRuleInstanceRef returns [EObject current=null] : iv_ruleInstanceRef= ruleInstanceRef EOF ;
    public final EObject entryRuleInstanceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRef = null;


        try {
            // InternalRDL.g:1864:52: (iv_ruleInstanceRef= ruleInstanceRef EOF )
            // InternalRDL.g:1865:2: iv_ruleInstanceRef= ruleInstanceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstanceRef=ruleInstanceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceRef"


    // $ANTLR start "ruleInstanceRef"
    // InternalRDL.g:1871:1: ruleInstanceRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) ;
    public final EObject ruleInstanceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_tail_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1877:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) )
            // InternalRDL.g:1878:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            {
            // InternalRDL.g:1878:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            // InternalRDL.g:1879:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            {
            // InternalRDL.g:1879:3: ( (otherlv_0= RULE_ID ) )
            // InternalRDL.g:1880:4: (otherlv_0= RULE_ID )
            {
            // InternalRDL.g:1880:4: (otherlv_0= RULE_ID )
            // InternalRDL.g:1881:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInstanceRefRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getInstanceRefAccess().getInstanceEntityCrossReference_0_0());
              				
            }

            }


            }

            // InternalRDL.g:1895:3: (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalRDL.g:1896:4: otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalRDL.g:1900:4: ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    // InternalRDL.g:1901:5: (lv_tail_2_0= ruleHierInstanceRef )
                    {
                    // InternalRDL.g:1901:5: (lv_tail_2_0= ruleHierInstanceRef )
                    // InternalRDL.g:1902:6: lv_tail_2_0= ruleHierInstanceRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstanceRefAccess().getTailHierInstanceRefParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_tail_2_0=ruleHierInstanceRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getInstanceRefRule());
                      						}
                      						set(
                      							current,
                      							"tail",
                      							lv_tail_2_0,
                      							"com.minres.rdl.RDL.HierInstanceRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceRef"


    // $ANTLR start "entryRuleHierInstanceRef"
    // InternalRDL.g:1924:1: entryRuleHierInstanceRef returns [EObject current=null] : iv_ruleHierInstanceRef= ruleHierInstanceRef EOF ;
    public final EObject entryRuleHierInstanceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHierInstanceRef = null;


        try {
            // InternalRDL.g:1924:56: (iv_ruleHierInstanceRef= ruleHierInstanceRef EOF )
            // InternalRDL.g:1925:2: iv_ruleHierInstanceRef= ruleHierInstanceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHierInstanceRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHierInstanceRef=ruleHierInstanceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHierInstanceRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHierInstanceRef"


    // $ANTLR start "ruleHierInstanceRef"
    // InternalRDL.g:1931:1: ruleHierInstanceRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) ;
    public final EObject ruleHierInstanceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_tail_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1937:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) )
            // InternalRDL.g:1938:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            {
            // InternalRDL.g:1938:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            // InternalRDL.g:1939:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            {
            // InternalRDL.g:1939:3: ( (otherlv_0= RULE_ID ) )
            // InternalRDL.g:1940:4: (otherlv_0= RULE_ID )
            {
            // InternalRDL.g:1940:4: (otherlv_0= RULE_ID )
            // InternalRDL.g:1941:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					/* */
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHierInstanceRefRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getHierInstanceRefAccess().getInstanceComponentInstanceCrossReference_0_0());
              				
            }

            }


            }

            // InternalRDL.g:1955:3: (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==33) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalRDL.g:1956:4: otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getHierInstanceRefAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalRDL.g:1960:4: ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    // InternalRDL.g:1961:5: (lv_tail_2_0= ruleHierInstanceRef )
                    {
                    // InternalRDL.g:1961:5: (lv_tail_2_0= ruleHierInstanceRef )
                    // InternalRDL.g:1962:6: lv_tail_2_0= ruleHierInstanceRef
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getHierInstanceRefAccess().getTailHierInstanceRefParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_tail_2_0=ruleHierInstanceRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getHierInstanceRefRule());
                      						}
                      						set(
                      							current,
                      							"tail",
                      							lv_tail_2_0,
                      							"com.minres.rdl.RDL.HierInstanceRef");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHierInstanceRef"


    // $ANTLR start "entryRulePropertyAssignmentRhs"
    // InternalRDL.g:1984:1: entryRulePropertyAssignmentRhs returns [EObject current=null] : iv_rulePropertyAssignmentRhs= rulePropertyAssignmentRhs EOF ;
    public final EObject entryRulePropertyAssignmentRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssignmentRhs = null;


        try {
            // InternalRDL.g:1984:62: (iv_rulePropertyAssignmentRhs= rulePropertyAssignmentRhs EOF )
            // InternalRDL.g:1985:2: iv_rulePropertyAssignmentRhs= rulePropertyAssignmentRhs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyAssignmentRhsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyAssignmentRhs=rulePropertyAssignmentRhs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyAssignmentRhs; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAssignmentRhs"


    // $ANTLR start "rulePropertyAssignmentRhs"
    // InternalRDL.g:1991:1: rulePropertyAssignmentRhs returns [EObject current=null] : ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) ) ;
    public final EObject rulePropertyAssignmentRhs() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_value_0_0 = null;

        EObject lv_instPropRef_1_0 = null;

        EObject lv_enums_4_0 = null;

        EObject lv_elements_5_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1997:2: ( ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) ) )
            // InternalRDL.g:1998:2: ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) )
            {
            // InternalRDL.g:1998:2: ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) )
            int alt33=4;
            switch ( input.LA(1) ) {
            case RULE_STR:
            case RULE_NUM:
            case 20:
            case 21:
            case 106:
            case 107:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
                {
                alt33=1;
                }
                break;
            case RULE_ID:
                {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==EOF||LA33_2==12||(LA33_2>=32 && LA33_2<=33)) ) {
                    alt33=2;
                }
                else if ( (LA33_2==34) ) {
                    alt33=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt33=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalRDL.g:1999:3: ( (lv_value_0_0= rulePropertyRvalueConstant ) )
                    {
                    // InternalRDL.g:1999:3: ( (lv_value_0_0= rulePropertyRvalueConstant ) )
                    // InternalRDL.g:2000:4: (lv_value_0_0= rulePropertyRvalueConstant )
                    {
                    // InternalRDL.g:2000:4: (lv_value_0_0= rulePropertyRvalueConstant )
                    // InternalRDL.g:2001:5: lv_value_0_0= rulePropertyRvalueConstant
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getValuePropertyRvalueConstantParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=rulePropertyRvalueConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyAssignmentRhsRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_0_0,
                      						"com.minres.rdl.RDL.PropertyRvalueConstant");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2019:3: ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) )
                    {
                    // InternalRDL.g:2019:3: ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) )
                    // InternalRDL.g:2020:4: (lv_instPropRef_1_0= ruleInstancePropertyRef )
                    {
                    // InternalRDL.g:2020:4: (lv_instPropRef_1_0= ruleInstancePropertyRef )
                    // InternalRDL.g:2021:5: lv_instPropRef_1_0= ruleInstancePropertyRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getInstPropRefInstancePropertyRefParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instPropRef_1_0=ruleInstancePropertyRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyAssignmentRhsRule());
                      					}
                      					set(
                      						current,
                      						"instPropRef",
                      						lv_instPropRef_1_0,
                      						"com.minres.rdl.RDL.InstancePropertyRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2039:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) )
                    {
                    // InternalRDL.g:2039:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) )
                    // InternalRDL.g:2040:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) )
                    {
                    // InternalRDL.g:2040:4: ( (otherlv_2= RULE_ID ) )
                    // InternalRDL.g:2041:5: (otherlv_2= RULE_ID )
                    {
                    // InternalRDL.g:2041:5: (otherlv_2= RULE_ID )
                    // InternalRDL.g:2042:6: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						/* */
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPropertyAssignmentRhsRule());
                      						}
                      					
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_2, grammarAccess.getPropertyAssignmentRhsAccess().getEnumRefEnumDefinitionCrossReference_2_0_0());
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,34,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPropertyAssignmentRhsAccess().getEnumKeyword_2_1());
                      			
                    }
                    // InternalRDL.g:2060:4: ( (lv_enums_4_0= ruleEnumBody ) )
                    // InternalRDL.g:2061:5: (lv_enums_4_0= ruleEnumBody )
                    {
                    // InternalRDL.g:2061:5: (lv_enums_4_0= ruleEnumBody )
                    // InternalRDL.g:2062:6: lv_enums_4_0= ruleEnumBody
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getEnumsEnumBodyParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_enums_4_0=ruleEnumBody();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPropertyAssignmentRhsRule());
                      						}
                      						set(
                      							current,
                      							"enums",
                      							lv_enums_4_0,
                      							"com.minres.rdl.RDL.EnumBody");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2081:3: ( (lv_elements_5_0= ruleConcat ) )
                    {
                    // InternalRDL.g:2081:3: ( (lv_elements_5_0= ruleConcat ) )
                    // InternalRDL.g:2082:4: (lv_elements_5_0= ruleConcat )
                    {
                    // InternalRDL.g:2082:4: (lv_elements_5_0= ruleConcat )
                    // InternalRDL.g:2083:5: lv_elements_5_0= ruleConcat
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getElementsConcatParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_elements_5_0=ruleConcat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyAssignmentRhsRule());
                      					}
                      					set(
                      						current,
                      						"elements",
                      						lv_elements_5_0,
                      						"com.minres.rdl.RDL.Concat");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyAssignmentRhs"


    // $ANTLR start "entryRuleConcat"
    // InternalRDL.g:2104:1: entryRuleConcat returns [EObject current=null] : iv_ruleConcat= ruleConcat EOF ;
    public final EObject entryRuleConcat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcat = null;


        try {
            // InternalRDL.g:2104:47: (iv_ruleConcat= ruleConcat EOF )
            // InternalRDL.g:2105:2: iv_ruleConcat= ruleConcat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConcat=ruleConcat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcat"


    // $ANTLR start "ruleConcat"
    // InternalRDL.g:2111:1: ruleConcat returns [EObject current=null] : (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleConcat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2117:2: ( (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' ) )
            // InternalRDL.g:2118:2: (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' )
            {
            // InternalRDL.g:2118:2: (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' )
            // InternalRDL.g:2119:3: otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConcatAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalRDL.g:2123:3: ( (lv_elements_1_0= ruleConcatElem ) )
            // InternalRDL.g:2124:4: (lv_elements_1_0= ruleConcatElem )
            {
            // InternalRDL.g:2124:4: (lv_elements_1_0= ruleConcatElem )
            // InternalRDL.g:2125:5: lv_elements_1_0= ruleConcatElem
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConcatAccess().getElementsConcatElemParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_42);
            lv_elements_1_0=ruleConcatElem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConcatRule());
              					}
              					add(
              						current,
              						"elements",
              						lv_elements_1_0,
              						"com.minres.rdl.RDL.ConcatElem");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRDL.g:2142:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==25) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalRDL.g:2143:4: otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getConcatAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalRDL.g:2147:4: ( (lv_elements_3_0= ruleConcatElem ) )
            	    // InternalRDL.g:2148:5: (lv_elements_3_0= ruleConcatElem )
            	    {
            	    // InternalRDL.g:2148:5: (lv_elements_3_0= ruleConcatElem )
            	    // InternalRDL.g:2149:6: lv_elements_3_0= ruleConcatElem
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getConcatAccess().getElementsConcatElemParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_elements_3_0=ruleConcatElem();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getConcatRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_3_0,
            	      							"com.minres.rdl.RDL.ConcatElem");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getConcatAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcat"


    // $ANTLR start "entryRuleConcatElem"
    // InternalRDL.g:2175:1: entryRuleConcatElem returns [EObject current=null] : iv_ruleConcatElem= ruleConcatElem EOF ;
    public final EObject entryRuleConcatElem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatElem = null;


        try {
            // InternalRDL.g:2175:51: (iv_ruleConcatElem= ruleConcatElem EOF )
            // InternalRDL.g:2176:2: iv_ruleConcatElem= ruleConcatElem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcatElemRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConcatElem=ruleConcatElem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcatElem; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcatElem"


    // $ANTLR start "ruleConcatElem"
    // InternalRDL.g:2182:1: ruleConcatElem returns [EObject current=null] : ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) ) ;
    public final EObject ruleConcatElem() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_instPropRef_0_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2188:2: ( ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) ) )
            // InternalRDL.g:2189:2: ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) )
            {
            // InternalRDL.g:2189:2: ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_NUM) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalRDL.g:2190:3: ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) )
                    {
                    // InternalRDL.g:2190:3: ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) )
                    // InternalRDL.g:2191:4: (lv_instPropRef_0_0= ruleInstancePropertyRef )
                    {
                    // InternalRDL.g:2191:4: (lv_instPropRef_0_0= ruleInstancePropertyRef )
                    // InternalRDL.g:2192:5: lv_instPropRef_0_0= ruleInstancePropertyRef
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConcatElemAccess().getInstPropRefInstancePropertyRefParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_instPropRef_0_0=ruleInstancePropertyRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getConcatElemRule());
                      					}
                      					set(
                      						current,
                      						"instPropRef",
                      						lv_instPropRef_0_0,
                      						"com.minres.rdl.RDL.InstancePropertyRef");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2210:3: ( (lv_value_1_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:2210:3: ( (lv_value_1_0= RULE_NUM ) )
                    // InternalRDL.g:2211:4: (lv_value_1_0= RULE_NUM )
                    {
                    // InternalRDL.g:2211:4: (lv_value_1_0= RULE_NUM )
                    // InternalRDL.g:2212:5: lv_value_1_0= RULE_NUM
                    {
                    lv_value_1_0=(Token)match(input,RULE_NUM,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_value_1_0, grammarAccess.getConcatElemAccess().getValueNUMTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getConcatElemRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"value",
                      						lv_value_1_0,
                      						"com.minres.rdl.RDL.NUM");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcatElem"


    // $ANTLR start "entryRulePropertyRvalueConstant"
    // InternalRDL.g:2232:1: entryRulePropertyRvalueConstant returns [EObject current=null] : iv_rulePropertyRvalueConstant= rulePropertyRvalueConstant EOF ;
    public final EObject entryRulePropertyRvalueConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRvalueConstant = null;


        try {
            // InternalRDL.g:2232:63: (iv_rulePropertyRvalueConstant= rulePropertyRvalueConstant EOF )
            // InternalRDL.g:2233:2: iv_rulePropertyRvalueConstant= rulePropertyRvalueConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRvalueConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyRvalueConstant=rulePropertyRvalueConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyRvalueConstant; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyRvalueConstant"


    // $ANTLR start "rulePropertyRvalueConstant"
    // InternalRDL.g:2239:1: rulePropertyRvalueConstant returns [EObject current=null] : ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) ) ;
    public final EObject rulePropertyRvalueConstant() throws RecognitionException {
        EObject current = null;

        Token lv_num_1_0=null;
        Token lv_str_2_0=null;
        Enumerator lv_val_0_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2245:2: ( ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) ) )
            // InternalRDL.g:2246:2: ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) )
            {
            // InternalRDL.g:2246:2: ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 20:
            case 21:
            case 106:
            case 107:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
                {
                alt36=1;
                }
                break;
            case RULE_NUM:
                {
                alt36=2;
                }
                break;
            case RULE_STR:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalRDL.g:2247:3: ( (lv_val_0_0= ruleRValueConstant ) )
                    {
                    // InternalRDL.g:2247:3: ( (lv_val_0_0= ruleRValueConstant ) )
                    // InternalRDL.g:2248:4: (lv_val_0_0= ruleRValueConstant )
                    {
                    // InternalRDL.g:2248:4: (lv_val_0_0= ruleRValueConstant )
                    // InternalRDL.g:2249:5: lv_val_0_0= ruleRValueConstant
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPropertyRvalueConstantAccess().getValRValueConstantEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_val_0_0=ruleRValueConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPropertyRvalueConstantRule());
                      					}
                      					set(
                      						current,
                      						"val",
                      						lv_val_0_0,
                      						"com.minres.rdl.RDL.RValueConstant");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2267:3: ( (lv_num_1_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:2267:3: ( (lv_num_1_0= RULE_NUM ) )
                    // InternalRDL.g:2268:4: (lv_num_1_0= RULE_NUM )
                    {
                    // InternalRDL.g:2268:4: (lv_num_1_0= RULE_NUM )
                    // InternalRDL.g:2269:5: lv_num_1_0= RULE_NUM
                    {
                    lv_num_1_0=(Token)match(input,RULE_NUM,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_num_1_0, grammarAccess.getPropertyRvalueConstantAccess().getNumNUMTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPropertyRvalueConstantRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"num",
                      						lv_num_1_0,
                      						"com.minres.rdl.RDL.NUM");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2286:3: ( (lv_str_2_0= RULE_STR ) )
                    {
                    // InternalRDL.g:2286:3: ( (lv_str_2_0= RULE_STR ) )
                    // InternalRDL.g:2287:4: (lv_str_2_0= RULE_STR )
                    {
                    // InternalRDL.g:2287:4: (lv_str_2_0= RULE_STR )
                    // InternalRDL.g:2288:5: lv_str_2_0= RULE_STR
                    {
                    lv_str_2_0=(Token)match(input,RULE_STR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_str_2_0, grammarAccess.getPropertyRvalueConstantAccess().getStrSTRTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPropertyRvalueConstantRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"str",
                      						lv_str_2_0,
                      						"com.minres.rdl.RDL.STR");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyRvalueConstant"


    // $ANTLR start "entryRuleEnumDefinition"
    // InternalRDL.g:2308:1: entryRuleEnumDefinition returns [EObject current=null] : iv_ruleEnumDefinition= ruleEnumDefinition EOF ;
    public final EObject entryRuleEnumDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumDefinition = null;


        try {
            // InternalRDL.g:2308:55: (iv_ruleEnumDefinition= ruleEnumDefinition EOF )
            // InternalRDL.g:2309:2: iv_ruleEnumDefinition= ruleEnumDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumDefinition=ruleEnumDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumDefinition"


    // $ANTLR start "ruleEnumDefinition"
    // InternalRDL.g:2315:1: ruleEnumDefinition returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) ) ;
    public final EObject ruleEnumDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2321:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) ) )
            // InternalRDL.g:2322:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) )
            {
            // InternalRDL.g:2322:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) )
            // InternalRDL.g:2323:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumDefinitionAccess().getEnumKeyword_0());
              		
            }
            // InternalRDL.g:2327:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRDL.g:2328:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRDL.g:2328:4: (lv_name_1_0= RULE_ID )
            // InternalRDL.g:2329:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getEnumDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"com.minres.rdl.RDL.ID");
              				
            }

            }


            }

            // InternalRDL.g:2345:3: ( (lv_body_2_0= ruleEnumBody ) )
            // InternalRDL.g:2346:4: (lv_body_2_0= ruleEnumBody )
            {
            // InternalRDL.g:2346:4: (lv_body_2_0= ruleEnumBody )
            // InternalRDL.g:2347:5: lv_body_2_0= ruleEnumBody
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumDefinitionAccess().getBodyEnumBodyParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_2_0=ruleEnumBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumDefinitionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"com.minres.rdl.RDL.EnumBody");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumDefinition"


    // $ANTLR start "entryRuleEnumBody"
    // InternalRDL.g:2368:1: entryRuleEnumBody returns [EObject current=null] : iv_ruleEnumBody= ruleEnumBody EOF ;
    public final EObject entryRuleEnumBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBody = null;


        try {
            // InternalRDL.g:2368:49: (iv_ruleEnumBody= ruleEnumBody EOF )
            // InternalRDL.g:2369:2: iv_ruleEnumBody= ruleEnumBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumBodyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumBody=ruleEnumBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumBody; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumBody"


    // $ANTLR start "ruleEnumBody"
    // InternalRDL.g:2375:1: ruleEnumBody returns [EObject current=null] : (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' ) ;
    public final EObject ruleEnumBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2381:2: ( (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' ) )
            // InternalRDL.g:2382:2: (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' )
            {
            // InternalRDL.g:2382:2: (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' )
            // InternalRDL.g:2383:3: otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumBodyAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalRDL.g:2387:3: ()
            // InternalRDL.g:2388:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEnumBodyAccess().getEnumBodyAction_1(),
              					current);
              			
            }

            }

            // InternalRDL.g:2397:3: ( (lv_entries_2_0= ruleEnumEntry ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalRDL.g:2398:4: (lv_entries_2_0= ruleEnumEntry )
            	    {
            	    // InternalRDL.g:2398:4: (lv_entries_2_0= ruleEnumEntry )
            	    // InternalRDL.g:2399:5: lv_entries_2_0= ruleEnumEntry
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getEnumBodyAccess().getEntriesEnumEntryParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_entries_2_0=ruleEnumEntry();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getEnumBodyRule());
            	      					}
            	      					add(
            	      						current,
            	      						"entries",
            	      						lv_entries_2_0,
            	      						"com.minres.rdl.RDL.EnumEntry");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getEnumBodyAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumBody"


    // $ANTLR start "entryRuleEnumEntry"
    // InternalRDL.g:2424:1: entryRuleEnumEntry returns [EObject current=null] : iv_ruleEnumEntry= ruleEnumEntry EOF ;
    public final EObject entryRuleEnumEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumEntry = null;


        try {
            // InternalRDL.g:2424:50: (iv_ruleEnumEntry= ruleEnumEntry EOF )
            // InternalRDL.g:2425:2: iv_ruleEnumEntry= ruleEnumEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumEntryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumEntry=ruleEnumEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumEntry; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumEntry"


    // $ANTLR start "ruleEnumEntry"
    // InternalRDL.g:2431:1: ruleEnumEntry returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' ) ;
    public final EObject ruleEnumEntry() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_index_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_properties_4_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2437:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' ) )
            // InternalRDL.g:2438:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' )
            {
            // InternalRDL.g:2438:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' )
            // InternalRDL.g:2439:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';'
            {
            // InternalRDL.g:2439:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRDL.g:2440:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRDL.g:2440:4: (lv_name_0_0= RULE_ID )
            // InternalRDL.g:2441:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getEnumEntryAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumEntryRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"com.minres.rdl.RDL.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumEntryAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalRDL.g:2461:3: ( (lv_index_2_0= RULE_NUM ) )
            // InternalRDL.g:2462:4: (lv_index_2_0= RULE_NUM )
            {
            // InternalRDL.g:2462:4: (lv_index_2_0= RULE_NUM )
            // InternalRDL.g:2463:5: lv_index_2_0= RULE_NUM
            {
            lv_index_2_0=(Token)match(input,RULE_NUM,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_index_2_0, grammarAccess.getEnumEntryAccess().getIndexNUMTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumEntryRule());
              					}
              					setWithLastConsumed(
              						current,
              						"index",
              						lv_index_2_0,
              						"com.minres.rdl.RDL.NUM");
              				
            }

            }


            }

            // InternalRDL.g:2479:3: (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==15) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRDL.g:2480:4: otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getEnumEntryAccess().getLeftCurlyBracketKeyword_3_0());
                      			
                    }
                    // InternalRDL.g:2484:4: ( (lv_properties_4_0= ruleEnumProperty ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=35 && LA38_0<=36)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalRDL.g:2485:5: (lv_properties_4_0= ruleEnumProperty )
                    	    {
                    	    // InternalRDL.g:2485:5: (lv_properties_4_0= ruleEnumProperty )
                    	    // InternalRDL.g:2486:6: lv_properties_4_0= ruleEnumProperty
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getEnumEntryAccess().getPropertiesEnumPropertyParserRuleCall_3_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_45);
                    	    lv_properties_4_0=ruleEnumProperty();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getEnumEntryRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"properties",
                    	      							lv_properties_4_0,
                    	      							"com.minres.rdl.RDL.EnumProperty");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getEnumEntryAccess().getRightCurlyBracketKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_6=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumEntryAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumEntry"


    // $ANTLR start "entryRuleEnumProperty"
    // InternalRDL.g:2516:1: entryRuleEnumProperty returns [EObject current=null] : iv_ruleEnumProperty= ruleEnumProperty EOF ;
    public final EObject entryRuleEnumProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumProperty = null;


        try {
            // InternalRDL.g:2516:53: (iv_ruleEnumProperty= ruleEnumProperty EOF )
            // InternalRDL.g:2517:2: iv_ruleEnumProperty= ruleEnumProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumPropertyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumProperty=ruleEnumProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumProperty; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumProperty"


    // $ANTLR start "ruleEnumProperty"
    // InternalRDL.g:2523:1: ruleEnumProperty returns [EObject current=null] : ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' ) ;
    public final EObject ruleEnumProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalRDL.g:2529:2: ( ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' ) )
            // InternalRDL.g:2530:2: ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' )
            {
            // InternalRDL.g:2530:2: ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' )
            // InternalRDL.g:2531:3: ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';'
            {
            // InternalRDL.g:2531:3: ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            else if ( (LA40_0==36) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalRDL.g:2532:4: ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) )
                    {
                    // InternalRDL.g:2532:4: ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) )
                    // InternalRDL.g:2533:5: ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) )
                    {
                    // InternalRDL.g:2533:5: ( (lv_name_0_0= 'name' ) )
                    // InternalRDL.g:2534:6: (lv_name_0_0= 'name' )
                    {
                    // InternalRDL.g:2534:6: (lv_name_0_0= 'name' )
                    // InternalRDL.g:2535:7: lv_name_0_0= 'name'
                    {
                    lv_name_0_0=(Token)match(input,35,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_name_0_0, grammarAccess.getEnumPropertyAccess().getNameNameKeyword_0_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getEnumPropertyRule());
                      							}
                      							setWithLastConsumed(current, "name", lv_name_0_0, "name");
                      						
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getEnumPropertyAccess().getEqualsSignKeyword_0_0_1());
                      				
                    }
                    // InternalRDL.g:2551:5: ( (lv_value_2_0= RULE_STR ) )
                    // InternalRDL.g:2552:6: (lv_value_2_0= RULE_STR )
                    {
                    // InternalRDL.g:2552:6: (lv_value_2_0= RULE_STR )
                    // InternalRDL.g:2553:7: lv_value_2_0= RULE_STR
                    {
                    lv_value_2_0=(Token)match(input,RULE_STR,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_value_2_0, grammarAccess.getEnumPropertyAccess().getValueSTRTerminalRuleCall_0_0_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getEnumPropertyRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"value",
                      								lv_value_2_0,
                      								"com.minres.rdl.RDL.STR");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2571:4: ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) )
                    {
                    // InternalRDL.g:2571:4: ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) )
                    // InternalRDL.g:2572:5: ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) )
                    {
                    // InternalRDL.g:2572:5: ( (lv_name_3_0= 'desc' ) )
                    // InternalRDL.g:2573:6: (lv_name_3_0= 'desc' )
                    {
                    // InternalRDL.g:2573:6: (lv_name_3_0= 'desc' )
                    // InternalRDL.g:2574:7: lv_name_3_0= 'desc'
                    {
                    lv_name_3_0=(Token)match(input,36,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_name_3_0, grammarAccess.getEnumPropertyAccess().getNameDescKeyword_0_1_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getEnumPropertyRule());
                      							}
                      							setWithLastConsumed(current, "name", lv_name_3_0, "desc");
                      						
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getEnumPropertyAccess().getEqualsSignKeyword_0_1_1());
                      				
                    }
                    // InternalRDL.g:2590:5: ( (lv_value_5_0= RULE_STR ) )
                    // InternalRDL.g:2591:6: (lv_value_5_0= RULE_STR )
                    {
                    // InternalRDL.g:2591:6: (lv_value_5_0= RULE_STR )
                    // InternalRDL.g:2592:7: lv_value_5_0= RULE_STR
                    {
                    lv_value_5_0=(Token)match(input,RULE_STR,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_value_5_0, grammarAccess.getEnumPropertyAccess().getValueSTRTerminalRuleCall_0_1_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getEnumPropertyRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"value",
                      								lv_value_5_0,
                      								"com.minres.rdl.RDL.STR");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,12,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumPropertyAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumProperty"


    // $ANTLR start "entryRuleEnumInstanceType"
    // InternalRDL.g:2618:1: entryRuleEnumInstanceType returns [EObject current=null] : iv_ruleEnumInstanceType= ruleEnumInstanceType EOF ;
    public final EObject entryRuleEnumInstanceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumInstanceType = null;


        try {
            // InternalRDL.g:2618:57: (iv_ruleEnumInstanceType= ruleEnumInstanceType EOF )
            // InternalRDL.g:2619:2: iv_ruleEnumInstanceType= ruleEnumInstanceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumInstanceTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumInstanceType=ruleEnumInstanceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumInstanceType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumInstanceType"


    // $ANTLR start "ruleEnumInstanceType"
    // InternalRDL.g:2625:1: ruleEnumInstanceType returns [EObject current=null] : ( ( (lv_EXTERNAL_0_0= 'external' ) ) | ( (lv_INTERNAL_1_0= 'internal' ) ) ) ;
    public final EObject ruleEnumInstanceType() throws RecognitionException {
        EObject current = null;

        Token lv_EXTERNAL_0_0=null;
        Token lv_INTERNAL_1_0=null;


        	enterRule();

        try {
            // InternalRDL.g:2631:2: ( ( ( (lv_EXTERNAL_0_0= 'external' ) ) | ( (lv_INTERNAL_1_0= 'internal' ) ) ) )
            // InternalRDL.g:2632:2: ( ( (lv_EXTERNAL_0_0= 'external' ) ) | ( (lv_INTERNAL_1_0= 'internal' ) ) )
            {
            // InternalRDL.g:2632:2: ( ( (lv_EXTERNAL_0_0= 'external' ) ) | ( (lv_INTERNAL_1_0= 'internal' ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==37) ) {
                alt41=1;
            }
            else if ( (LA41_0==38) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalRDL.g:2633:3: ( (lv_EXTERNAL_0_0= 'external' ) )
                    {
                    // InternalRDL.g:2633:3: ( (lv_EXTERNAL_0_0= 'external' ) )
                    // InternalRDL.g:2634:4: (lv_EXTERNAL_0_0= 'external' )
                    {
                    // InternalRDL.g:2634:4: (lv_EXTERNAL_0_0= 'external' )
                    // InternalRDL.g:2635:5: lv_EXTERNAL_0_0= 'external'
                    {
                    lv_EXTERNAL_0_0=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_EXTERNAL_0_0, grammarAccess.getEnumInstanceTypeAccess().getEXTERNALExternalKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEnumInstanceTypeRule());
                      					}
                      					setWithLastConsumed(current, "EXTERNAL", lv_EXTERNAL_0_0, "external");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2648:3: ( (lv_INTERNAL_1_0= 'internal' ) )
                    {
                    // InternalRDL.g:2648:3: ( (lv_INTERNAL_1_0= 'internal' ) )
                    // InternalRDL.g:2649:4: (lv_INTERNAL_1_0= 'internal' )
                    {
                    // InternalRDL.g:2649:4: (lv_INTERNAL_1_0= 'internal' )
                    // InternalRDL.g:2650:5: lv_INTERNAL_1_0= 'internal'
                    {
                    lv_INTERNAL_1_0=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_INTERNAL_1_0, grammarAccess.getEnumInstanceTypeAccess().getINTERNALInternalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEnumInstanceTypeRule());
                      					}
                      					setWithLastConsumed(current, "INTERNAL", lv_INTERNAL_1_0, "internal");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumInstanceType"


    // $ANTLR start "rulePropertyTypeName"
    // InternalRDL.g:2666:1: rulePropertyTypeName returns [Enumerator current=null] : ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) ) ;
    public final Enumerator rulePropertyTypeName() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalRDL.g:2672:2: ( ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) ) )
            // InternalRDL.g:2673:2: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) )
            {
            // InternalRDL.g:2673:2: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) )
            int alt42=8;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt42=1;
                }
                break;
            case 40:
                {
                alt42=2;
                }
                break;
            case 41:
                {
                alt42=3;
                }
                break;
            case 42:
                {
                alt42=4;
                }
                break;
            case 43:
                {
                alt42=5;
                }
                break;
            case 44:
                {
                alt42=6;
                }
                break;
            case 45:
                {
                alt42=7;
                }
                break;
            case 46:
                {
                alt42=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalRDL.g:2674:3: (enumLiteral_0= 'string' )
                    {
                    // InternalRDL.g:2674:3: (enumLiteral_0= 'string' )
                    // InternalRDL.g:2675:4: enumLiteral_0= 'string'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPropertyTypeNameAccess().getSTRINGEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2682:3: (enumLiteral_1= 'number' )
                    {
                    // InternalRDL.g:2682:3: (enumLiteral_1= 'number' )
                    // InternalRDL.g:2683:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPropertyTypeNameAccess().getNUMBEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2690:3: (enumLiteral_2= 'boolean' )
                    {
                    // InternalRDL.g:2690:3: (enumLiteral_2= 'boolean' )
                    // InternalRDL.g:2691:4: enumLiteral_2= 'boolean'
                    {
                    enumLiteral_2=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getBOOLEANEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getPropertyTypeNameAccess().getBOOLEANEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2698:3: (enumLiteral_3= 'addrmap' )
                    {
                    // InternalRDL.g:2698:3: (enumLiteral_3= 'addrmap' )
                    // InternalRDL.g:2699:4: enumLiteral_3= 'addrmap'
                    {
                    enumLiteral_3=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getADDRMAPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getPropertyTypeNameAccess().getADDRMAPEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2706:3: (enumLiteral_4= 'reg' )
                    {
                    // InternalRDL.g:2706:3: (enumLiteral_4= 'reg' )
                    // InternalRDL.g:2707:4: enumLiteral_4= 'reg'
                    {
                    enumLiteral_4=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getREGEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getPropertyTypeNameAccess().getREGEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:2714:3: (enumLiteral_5= 'regfile' )
                    {
                    // InternalRDL.g:2714:3: (enumLiteral_5= 'regfile' )
                    // InternalRDL.g:2715:4: enumLiteral_5= 'regfile'
                    {
                    enumLiteral_5=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getREGFILEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getPropertyTypeNameAccess().getREGFILEEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRDL.g:2722:3: (enumLiteral_6= 'field' )
                    {
                    // InternalRDL.g:2722:3: (enumLiteral_6= 'field' )
                    // InternalRDL.g:2723:4: enumLiteral_6= 'field'
                    {
                    enumLiteral_6=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getFIELDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getPropertyTypeNameAccess().getFIELDEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalRDL.g:2730:3: (enumLiteral_7= 'ref' )
                    {
                    // InternalRDL.g:2730:3: (enumLiteral_7= 'ref' )
                    // InternalRDL.g:2731:4: enumLiteral_7= 'ref'
                    {
                    enumLiteral_7=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyTypeNameAccess().getREFEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getPropertyTypeNameAccess().getREFEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyTypeName"


    // $ANTLR start "rulePropertyComponent"
    // InternalRDL.g:2741:1: rulePropertyComponent returns [Enumerator current=null] : ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) ) ;
    public final Enumerator rulePropertyComponent() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalRDL.g:2747:2: ( ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) ) )
            // InternalRDL.g:2748:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) )
            {
            // InternalRDL.g:2748:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) )
            int alt43=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt43=1;
                }
                break;
            case 42:
                {
                alt43=2;
                }
                break;
            case 43:
                {
                alt43=3;
                }
                break;
            case 44:
                {
                alt43=4;
                }
                break;
            case 45:
                {
                alt43=5;
                }
                break;
            case 48:
                {
                alt43=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalRDL.g:2749:3: (enumLiteral_0= 'signal' )
                    {
                    // InternalRDL.g:2749:3: (enumLiteral_0= 'signal' )
                    // InternalRDL.g:2750:4: enumLiteral_0= 'signal'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyComponentAccess().getSIGNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPropertyComponentAccess().getSIGNALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2757:3: (enumLiteral_1= 'addrmap' )
                    {
                    // InternalRDL.g:2757:3: (enumLiteral_1= 'addrmap' )
                    // InternalRDL.g:2758:4: enumLiteral_1= 'addrmap'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyComponentAccess().getADDRMAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPropertyComponentAccess().getADDRMAPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2765:3: (enumLiteral_2= 'reg' )
                    {
                    // InternalRDL.g:2765:3: (enumLiteral_2= 'reg' )
                    // InternalRDL.g:2766:4: enumLiteral_2= 'reg'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyComponentAccess().getREGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getPropertyComponentAccess().getREGEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2773:3: (enumLiteral_3= 'regfile' )
                    {
                    // InternalRDL.g:2773:3: (enumLiteral_3= 'regfile' )
                    // InternalRDL.g:2774:4: enumLiteral_3= 'regfile'
                    {
                    enumLiteral_3=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyComponentAccess().getREGFILEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getPropertyComponentAccess().getREGFILEEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2781:3: (enumLiteral_4= 'field' )
                    {
                    // InternalRDL.g:2781:3: (enumLiteral_4= 'field' )
                    // InternalRDL.g:2782:4: enumLiteral_4= 'field'
                    {
                    enumLiteral_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyComponentAccess().getFIELDEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getPropertyComponentAccess().getFIELDEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:2789:3: (enumLiteral_5= 'all' )
                    {
                    // InternalRDL.g:2789:3: (enumLiteral_5= 'all' )
                    // InternalRDL.g:2790:4: enumLiteral_5= 'all'
                    {
                    enumLiteral_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyComponentAccess().getALLEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getPropertyComponentAccess().getALLEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyComponent"


    // $ANTLR start "ruleComponentDefinitionType"
    // InternalRDL.g:2800:1: ruleComponentDefinitionType returns [Enumerator current=null] : ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) ) ;
    public final Enumerator ruleComponentDefinitionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalRDL.g:2806:2: ( ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) ) )
            // InternalRDL.g:2807:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) )
            {
            // InternalRDL.g:2807:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) )
            int alt44=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt44=1;
                }
                break;
            case 42:
                {
                alt44=2;
                }
                break;
            case 44:
                {
                alt44=3;
                }
                break;
            case 43:
                {
                alt44=4;
                }
                break;
            case 45:
                {
                alt44=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalRDL.g:2808:3: (enumLiteral_0= 'signal' )
                    {
                    // InternalRDL.g:2808:3: (enumLiteral_0= 'signal' )
                    // InternalRDL.g:2809:4: enumLiteral_0= 'signal'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComponentDefinitionTypeAccess().getSIGNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getComponentDefinitionTypeAccess().getSIGNALEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2816:3: (enumLiteral_1= 'addrmap' )
                    {
                    // InternalRDL.g:2816:3: (enumLiteral_1= 'addrmap' )
                    // InternalRDL.g:2817:4: enumLiteral_1= 'addrmap'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComponentDefinitionTypeAccess().getADDRMAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getComponentDefinitionTypeAccess().getADDRMAPEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2824:3: (enumLiteral_2= 'regfile' )
                    {
                    // InternalRDL.g:2824:3: (enumLiteral_2= 'regfile' )
                    // InternalRDL.g:2825:4: enumLiteral_2= 'regfile'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComponentDefinitionTypeAccess().getREGFILEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getComponentDefinitionTypeAccess().getREGFILEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2832:3: (enumLiteral_3= 'reg' )
                    {
                    // InternalRDL.g:2832:3: (enumLiteral_3= 'reg' )
                    // InternalRDL.g:2833:4: enumLiteral_3= 'reg'
                    {
                    enumLiteral_3=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComponentDefinitionTypeAccess().getREGEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getComponentDefinitionTypeAccess().getREGEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2840:3: (enumLiteral_4= 'field' )
                    {
                    // InternalRDL.g:2840:3: (enumLiteral_4= 'field' )
                    // InternalRDL.g:2841:4: enumLiteral_4= 'field'
                    {
                    enumLiteral_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getComponentDefinitionTypeAccess().getFIELDEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getComponentDefinitionTypeAccess().getFIELDEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentDefinitionType"


    // $ANTLR start "ruleProperty"
    // InternalRDL.g:2851:1: ruleProperty returns [Enumerator current=null] : ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) ) ;
    public final Enumerator ruleProperty() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;
        Token enumLiteral_27=null;
        Token enumLiteral_28=null;
        Token enumLiteral_29=null;
        Token enumLiteral_30=null;
        Token enumLiteral_31=null;
        Token enumLiteral_32=null;
        Token enumLiteral_33=null;
        Token enumLiteral_34=null;
        Token enumLiteral_35=null;
        Token enumLiteral_36=null;
        Token enumLiteral_37=null;
        Token enumLiteral_38=null;
        Token enumLiteral_39=null;
        Token enumLiteral_40=null;
        Token enumLiteral_41=null;
        Token enumLiteral_42=null;
        Token enumLiteral_43=null;
        Token enumLiteral_44=null;
        Token enumLiteral_45=null;
        Token enumLiteral_46=null;
        Token enumLiteral_47=null;
        Token enumLiteral_48=null;
        Token enumLiteral_49=null;
        Token enumLiteral_50=null;
        Token enumLiteral_51=null;
        Token enumLiteral_52=null;
        Token enumLiteral_53=null;
        Token enumLiteral_54=null;
        Token enumLiteral_55=null;
        Token enumLiteral_56=null;
        Token enumLiteral_57=null;
        Token enumLiteral_58=null;
        Token enumLiteral_59=null;
        Token enumLiteral_60=null;
        Token enumLiteral_61=null;
        Token enumLiteral_62=null;
        Token enumLiteral_63=null;
        Token enumLiteral_64=null;
        Token enumLiteral_65=null;
        Token enumLiteral_66=null;
        Token enumLiteral_67=null;
        Token enumLiteral_68=null;
        Token enumLiteral_69=null;
        Token enumLiteral_70=null;
        Token enumLiteral_71=null;
        Token enumLiteral_72=null;
        Token enumLiteral_73=null;
        Token enumLiteral_74=null;


        	enterRule();

        try {
            // InternalRDL.g:2857:2: ( ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) ) )
            // InternalRDL.g:2858:2: ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) )
            {
            // InternalRDL.g:2858:2: ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) )
            int alt45=75;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt45=1;
                }
                break;
            case 36:
                {
                alt45=2;
                }
                break;
            case 49:
                {
                alt45=3;
                }
                break;
            case 50:
                {
                alt45=4;
                }
                break;
            case 51:
                {
                alt45=5;
                }
                break;
            case 52:
                {
                alt45=6;
                }
                break;
            case 53:
                {
                alt45=7;
                }
                break;
            case 54:
                {
                alt45=8;
                }
                break;
            case 55:
                {
                alt45=9;
                }
                break;
            case 56:
                {
                alt45=10;
                }
                break;
            case 57:
                {
                alt45=11;
                }
                break;
            case 58:
                {
                alt45=12;
                }
                break;
            case 59:
                {
                alt45=13;
                }
                break;
            case 60:
                {
                alt45=14;
                }
                break;
            case 61:
                {
                alt45=15;
                }
                break;
            case 62:
                {
                alt45=16;
                }
                break;
            case 63:
                {
                alt45=17;
                }
                break;
            case 64:
                {
                alt45=18;
                }
                break;
            case 65:
                {
                alt45=19;
                }
                break;
            case 66:
                {
                alt45=20;
                }
                break;
            case 67:
                {
                alt45=21;
                }
                break;
            case 68:
                {
                alt45=22;
                }
                break;
            case 69:
                {
                alt45=23;
                }
                break;
            case 70:
                {
                alt45=24;
                }
                break;
            case 71:
                {
                alt45=25;
                }
                break;
            case 72:
                {
                alt45=26;
                }
                break;
            case 73:
                {
                alt45=27;
                }
                break;
            case 74:
                {
                alt45=28;
                }
                break;
            case 75:
                {
                alt45=29;
                }
                break;
            case 76:
                {
                alt45=30;
                }
                break;
            case 77:
                {
                alt45=31;
                }
                break;
            case 78:
                {
                alt45=32;
                }
                break;
            case 79:
                {
                alt45=33;
                }
                break;
            case 80:
                {
                alt45=34;
                }
                break;
            case 81:
                {
                alt45=35;
                }
                break;
            case 82:
                {
                alt45=36;
                }
                break;
            case 83:
                {
                alt45=37;
                }
                break;
            case 84:
                {
                alt45=38;
                }
                break;
            case 85:
                {
                alt45=39;
                }
                break;
            case 86:
                {
                alt45=40;
                }
                break;
            case 87:
                {
                alt45=41;
                }
                break;
            case 88:
                {
                alt45=42;
                }
                break;
            case 89:
                {
                alt45=43;
                }
                break;
            case 90:
                {
                alt45=44;
                }
                break;
            case 91:
                {
                alt45=45;
                }
                break;
            case 92:
                {
                alt45=46;
                }
                break;
            case 93:
                {
                alt45=47;
                }
                break;
            case 94:
                {
                alt45=48;
                }
                break;
            case 95:
                {
                alt45=49;
                }
                break;
            case 96:
                {
                alt45=50;
                }
                break;
            case 97:
                {
                alt45=51;
                }
                break;
            case 98:
                {
                alt45=52;
                }
                break;
            case 99:
                {
                alt45=53;
                }
                break;
            case 100:
                {
                alt45=54;
                }
                break;
            case 38:
                {
                alt45=55;
                }
                break;
            case 101:
                {
                alt45=56;
                }
                break;
            case 102:
                {
                alt45=57;
                }
                break;
            case 103:
                {
                alt45=58;
                }
                break;
            case 104:
                {
                alt45=59;
                }
                break;
            case 105:
                {
                alt45=60;
                }
                break;
            case 106:
                {
                alt45=61;
                }
                break;
            case 107:
                {
                alt45=62;
                }
                break;
            case 108:
                {
                alt45=63;
                }
                break;
            case 109:
                {
                alt45=64;
                }
                break;
            case 110:
                {
                alt45=65;
                }
                break;
            case 111:
                {
                alt45=66;
                }
                break;
            case 112:
                {
                alt45=67;
                }
                break;
            case 113:
                {
                alt45=68;
                }
                break;
            case 114:
                {
                alt45=69;
                }
                break;
            case 115:
                {
                alt45=70;
                }
                break;
            case 116:
                {
                alt45=71;
                }
                break;
            case 117:
                {
                alt45=72;
                }
                break;
            case 118:
                {
                alt45=73;
                }
                break;
            case 119:
                {
                alt45=74;
                }
                break;
            case 120:
                {
                alt45=75;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalRDL.g:2859:3: (enumLiteral_0= 'name' )
                    {
                    // InternalRDL.g:2859:3: (enumLiteral_0= 'name' )
                    // InternalRDL.g:2860:4: enumLiteral_0= 'name'
                    {
                    enumLiteral_0=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getNAMEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPropertyAccess().getNAMEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2867:3: (enumLiteral_1= 'desc' )
                    {
                    // InternalRDL.g:2867:3: (enumLiteral_1= 'desc' )
                    // InternalRDL.g:2868:4: enumLiteral_1= 'desc'
                    {
                    enumLiteral_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDESCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPropertyAccess().getDESCEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2875:3: (enumLiteral_2= 'arbiter' )
                    {
                    // InternalRDL.g:2875:3: (enumLiteral_2= 'arbiter' )
                    // InternalRDL.g:2876:4: enumLiteral_2= 'arbiter'
                    {
                    enumLiteral_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getARBITEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getPropertyAccess().getARBITEREnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2883:3: (enumLiteral_3= 'rset' )
                    {
                    // InternalRDL.g:2883:3: (enumLiteral_3= 'rset' )
                    // InternalRDL.g:2884:4: enumLiteral_3= 'rset'
                    {
                    enumLiteral_3=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getRSETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getPropertyAccess().getRSETEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2891:3: (enumLiteral_4= 'rclr' )
                    {
                    // InternalRDL.g:2891:3: (enumLiteral_4= 'rclr' )
                    // InternalRDL.g:2892:4: enumLiteral_4= 'rclr'
                    {
                    enumLiteral_4=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getRCLREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getPropertyAccess().getRCLREnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:2899:3: (enumLiteral_5= 'woclr' )
                    {
                    // InternalRDL.g:2899:3: (enumLiteral_5= 'woclr' )
                    // InternalRDL.g:2900:4: enumLiteral_5= 'woclr'
                    {
                    enumLiteral_5=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getWOCLREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getPropertyAccess().getWOCLREnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRDL.g:2907:3: (enumLiteral_6= 'woset' )
                    {
                    // InternalRDL.g:2907:3: (enumLiteral_6= 'woset' )
                    // InternalRDL.g:2908:4: enumLiteral_6= 'woset'
                    {
                    enumLiteral_6=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getWOSETEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getPropertyAccess().getWOSETEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalRDL.g:2915:3: (enumLiteral_7= 'we' )
                    {
                    // InternalRDL.g:2915:3: (enumLiteral_7= 'we' )
                    // InternalRDL.g:2916:4: enumLiteral_7= 'we'
                    {
                    enumLiteral_7=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getWEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getPropertyAccess().getWEEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalRDL.g:2923:3: (enumLiteral_8= 'wel' )
                    {
                    // InternalRDL.g:2923:3: (enumLiteral_8= 'wel' )
                    // InternalRDL.g:2924:4: enumLiteral_8= 'wel'
                    {
                    enumLiteral_8=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getWELEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getPropertyAccess().getWELEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalRDL.g:2931:3: (enumLiteral_9= 'swwe' )
                    {
                    // InternalRDL.g:2931:3: (enumLiteral_9= 'swwe' )
                    // InternalRDL.g:2932:4: enumLiteral_9= 'swwe'
                    {
                    enumLiteral_9=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSWWEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getPropertyAccess().getSWWEEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalRDL.g:2939:3: (enumLiteral_10= 'swwel' )
                    {
                    // InternalRDL.g:2939:3: (enumLiteral_10= 'swwel' )
                    // InternalRDL.g:2940:4: enumLiteral_10= 'swwel'
                    {
                    enumLiteral_10=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSWWELEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getPropertyAccess().getSWWELEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalRDL.g:2947:3: (enumLiteral_11= 'hwset' )
                    {
                    // InternalRDL.g:2947:3: (enumLiteral_11= 'hwset' )
                    // InternalRDL.g:2948:4: enumLiteral_11= 'hwset'
                    {
                    enumLiteral_11=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHWSETEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getPropertyAccess().getHWSETEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalRDL.g:2955:3: (enumLiteral_12= 'hwclr' )
                    {
                    // InternalRDL.g:2955:3: (enumLiteral_12= 'hwclr' )
                    // InternalRDL.g:2956:4: enumLiteral_12= 'hwclr'
                    {
                    enumLiteral_12=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHWCLREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getPropertyAccess().getHWCLREnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalRDL.g:2963:3: (enumLiteral_13= 'swmod' )
                    {
                    // InternalRDL.g:2963:3: (enumLiteral_13= 'swmod' )
                    // InternalRDL.g:2964:4: enumLiteral_13= 'swmod'
                    {
                    enumLiteral_13=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSWMODEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_13, grammarAccess.getPropertyAccess().getSWMODEnumLiteralDeclaration_13());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalRDL.g:2971:3: (enumLiteral_14= 'swacc' )
                    {
                    // InternalRDL.g:2971:3: (enumLiteral_14= 'swacc' )
                    // InternalRDL.g:2972:4: enumLiteral_14= 'swacc'
                    {
                    enumLiteral_14=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSWACCEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_14, grammarAccess.getPropertyAccess().getSWACCEnumLiteralDeclaration_14());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalRDL.g:2979:3: (enumLiteral_15= 'sticky' )
                    {
                    // InternalRDL.g:2979:3: (enumLiteral_15= 'sticky' )
                    // InternalRDL.g:2980:4: enumLiteral_15= 'sticky'
                    {
                    enumLiteral_15=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSTICKYEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_15, grammarAccess.getPropertyAccess().getSTICKYEnumLiteralDeclaration_15());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalRDL.g:2987:3: (enumLiteral_16= 'stickybit' )
                    {
                    // InternalRDL.g:2987:3: (enumLiteral_16= 'stickybit' )
                    // InternalRDL.g:2988:4: enumLiteral_16= 'stickybit'
                    {
                    enumLiteral_16=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSTICKYBITEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_16, grammarAccess.getPropertyAccess().getSTICKYBITEnumLiteralDeclaration_16());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalRDL.g:2995:3: (enumLiteral_17= 'intr' )
                    {
                    // InternalRDL.g:2995:3: (enumLiteral_17= 'intr' )
                    // InternalRDL.g:2996:4: enumLiteral_17= 'intr'
                    {
                    enumLiteral_17=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getINTREnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_17, grammarAccess.getPropertyAccess().getINTREnumLiteralDeclaration_17());
                      			
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalRDL.g:3003:3: (enumLiteral_18= 'anded' )
                    {
                    // InternalRDL.g:3003:3: (enumLiteral_18= 'anded' )
                    // InternalRDL.g:3004:4: enumLiteral_18= 'anded'
                    {
                    enumLiteral_18=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getANDEDEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_18, grammarAccess.getPropertyAccess().getANDEDEnumLiteralDeclaration_18());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalRDL.g:3011:3: (enumLiteral_19= 'ored' )
                    {
                    // InternalRDL.g:3011:3: (enumLiteral_19= 'ored' )
                    // InternalRDL.g:3012:4: enumLiteral_19= 'ored'
                    {
                    enumLiteral_19=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getOREDEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_19, grammarAccess.getPropertyAccess().getOREDEnumLiteralDeclaration_19());
                      			
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalRDL.g:3019:3: (enumLiteral_20= 'xored' )
                    {
                    // InternalRDL.g:3019:3: (enumLiteral_20= 'xored' )
                    // InternalRDL.g:3020:4: enumLiteral_20= 'xored'
                    {
                    enumLiteral_20=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getXOREDEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_20, grammarAccess.getPropertyAccess().getXOREDEnumLiteralDeclaration_20());
                      			
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalRDL.g:3027:3: (enumLiteral_21= 'counter' )
                    {
                    // InternalRDL.g:3027:3: (enumLiteral_21= 'counter' )
                    // InternalRDL.g:3028:4: enumLiteral_21= 'counter'
                    {
                    enumLiteral_21=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getCOUNTEREnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_21, grammarAccess.getPropertyAccess().getCOUNTEREnumLiteralDeclaration_21());
                      			
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalRDL.g:3035:3: (enumLiteral_22= 'overflow' )
                    {
                    // InternalRDL.g:3035:3: (enumLiteral_22= 'overflow' )
                    // InternalRDL.g:3036:4: enumLiteral_22= 'overflow'
                    {
                    enumLiteral_22=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getOVERFLOWEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_22, grammarAccess.getPropertyAccess().getOVERFLOWEnumLiteralDeclaration_22());
                      			
                    }

                    }


                    }
                    break;
                case 24 :
                    // InternalRDL.g:3043:3: (enumLiteral_23= 'sharedextbus' )
                    {
                    // InternalRDL.g:3043:3: (enumLiteral_23= 'sharedextbus' )
                    // InternalRDL.g:3044:4: enumLiteral_23= 'sharedextbus'
                    {
                    enumLiteral_23=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSHAREDEXTBUSEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_23, grammarAccess.getPropertyAccess().getSHAREDEXTBUSEnumLiteralDeclaration_23());
                      			
                    }

                    }


                    }
                    break;
                case 25 :
                    // InternalRDL.g:3051:3: (enumLiteral_24= 'errextbus' )
                    {
                    // InternalRDL.g:3051:3: (enumLiteral_24= 'errextbus' )
                    // InternalRDL.g:3052:4: enumLiteral_24= 'errextbus'
                    {
                    enumLiteral_24=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getERREXTBUSEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_24, grammarAccess.getPropertyAccess().getERREXTBUSEnumLiteralDeclaration_24());
                      			
                    }

                    }


                    }
                    break;
                case 26 :
                    // InternalRDL.g:3059:3: (enumLiteral_25= 'reset' )
                    {
                    // InternalRDL.g:3059:3: (enumLiteral_25= 'reset' )
                    // InternalRDL.g:3060:4: enumLiteral_25= 'reset'
                    {
                    enumLiteral_25=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getRESETEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_25, grammarAccess.getPropertyAccess().getRESETEnumLiteralDeclaration_25());
                      			
                    }

                    }


                    }
                    break;
                case 27 :
                    // InternalRDL.g:3067:3: (enumLiteral_26= 'littleendian' )
                    {
                    // InternalRDL.g:3067:3: (enumLiteral_26= 'littleendian' )
                    // InternalRDL.g:3068:4: enumLiteral_26= 'littleendian'
                    {
                    enumLiteral_26=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getLITTLEENDIANEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_26, grammarAccess.getPropertyAccess().getLITTLEENDIANEnumLiteralDeclaration_26());
                      			
                    }

                    }


                    }
                    break;
                case 28 :
                    // InternalRDL.g:3075:3: (enumLiteral_27= 'bigendian' )
                    {
                    // InternalRDL.g:3075:3: (enumLiteral_27= 'bigendian' )
                    // InternalRDL.g:3076:4: enumLiteral_27= 'bigendian'
                    {
                    enumLiteral_27=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getBIGENDIANEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_27, grammarAccess.getPropertyAccess().getBIGENDIANEnumLiteralDeclaration_27());
                      			
                    }

                    }


                    }
                    break;
                case 29 :
                    // InternalRDL.g:3083:3: (enumLiteral_28= 'rsvdset' )
                    {
                    // InternalRDL.g:3083:3: (enumLiteral_28= 'rsvdset' )
                    // InternalRDL.g:3084:4: enumLiteral_28= 'rsvdset'
                    {
                    enumLiteral_28=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getRSVDSETEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_28, grammarAccess.getPropertyAccess().getRSVDSETEnumLiteralDeclaration_28());
                      			
                    }

                    }


                    }
                    break;
                case 30 :
                    // InternalRDL.g:3091:3: (enumLiteral_29= 'rsvdsetX' )
                    {
                    // InternalRDL.g:3091:3: (enumLiteral_29= 'rsvdsetX' )
                    // InternalRDL.g:3092:4: enumLiteral_29= 'rsvdsetX'
                    {
                    enumLiteral_29=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getRSVDSETXEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_29, grammarAccess.getPropertyAccess().getRSVDSETXEnumLiteralDeclaration_29());
                      			
                    }

                    }


                    }
                    break;
                case 31 :
                    // InternalRDL.g:3099:3: (enumLiteral_30= 'bridge' )
                    {
                    // InternalRDL.g:3099:3: (enumLiteral_30= 'bridge' )
                    // InternalRDL.g:3100:4: enumLiteral_30= 'bridge'
                    {
                    enumLiteral_30=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getBRIDGEEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_30, grammarAccess.getPropertyAccess().getBRIDGEEnumLiteralDeclaration_30());
                      			
                    }

                    }


                    }
                    break;
                case 32 :
                    // InternalRDL.g:3107:3: (enumLiteral_31= 'shared' )
                    {
                    // InternalRDL.g:3107:3: (enumLiteral_31= 'shared' )
                    // InternalRDL.g:3108:4: enumLiteral_31= 'shared'
                    {
                    enumLiteral_31=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSHAREDEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_31, grammarAccess.getPropertyAccess().getSHAREDEnumLiteralDeclaration_31());
                      			
                    }

                    }


                    }
                    break;
                case 33 :
                    // InternalRDL.g:3115:3: (enumLiteral_32= 'msb0' )
                    {
                    // InternalRDL.g:3115:3: (enumLiteral_32= 'msb0' )
                    // InternalRDL.g:3116:4: enumLiteral_32= 'msb0'
                    {
                    enumLiteral_32=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getMSB0EnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_32, grammarAccess.getPropertyAccess().getMSB0EnumLiteralDeclaration_32());
                      			
                    }

                    }


                    }
                    break;
                case 34 :
                    // InternalRDL.g:3123:3: (enumLiteral_33= 'lsb0' )
                    {
                    // InternalRDL.g:3123:3: (enumLiteral_33= 'lsb0' )
                    // InternalRDL.g:3124:4: enumLiteral_33= 'lsb0'
                    {
                    enumLiteral_33=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getLSB0EnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_33, grammarAccess.getPropertyAccess().getLSB0EnumLiteralDeclaration_33());
                      			
                    }

                    }


                    }
                    break;
                case 35 :
                    // InternalRDL.g:3131:3: (enumLiteral_34= 'sync' )
                    {
                    // InternalRDL.g:3131:3: (enumLiteral_34= 'sync' )
                    // InternalRDL.g:3132:4: enumLiteral_34= 'sync'
                    {
                    enumLiteral_34=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSYNCEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_34, grammarAccess.getPropertyAccess().getSYNCEnumLiteralDeclaration_34());
                      			
                    }

                    }


                    }
                    break;
                case 36 :
                    // InternalRDL.g:3139:3: (enumLiteral_35= 'async' )
                    {
                    // InternalRDL.g:3139:3: (enumLiteral_35= 'async' )
                    // InternalRDL.g:3140:4: enumLiteral_35= 'async'
                    {
                    enumLiteral_35=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getASYNCEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_35, grammarAccess.getPropertyAccess().getASYNCEnumLiteralDeclaration_35());
                      			
                    }

                    }


                    }
                    break;
                case 37 :
                    // InternalRDL.g:3147:3: (enumLiteral_36= 'cpuif_reset' )
                    {
                    // InternalRDL.g:3147:3: (enumLiteral_36= 'cpuif_reset' )
                    // InternalRDL.g:3148:4: enumLiteral_36= 'cpuif_reset'
                    {
                    enumLiteral_36=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getCPUIF_RESETEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_36, grammarAccess.getPropertyAccess().getCPUIF_RESETEnumLiteralDeclaration_36());
                      			
                    }

                    }


                    }
                    break;
                case 38 :
                    // InternalRDL.g:3155:3: (enumLiteral_37= 'field_reset' )
                    {
                    // InternalRDL.g:3155:3: (enumLiteral_37= 'field_reset' )
                    // InternalRDL.g:3156:4: enumLiteral_37= 'field_reset'
                    {
                    enumLiteral_37=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getFIELD_RESETEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_37, grammarAccess.getPropertyAccess().getFIELD_RESETEnumLiteralDeclaration_37());
                      			
                    }

                    }


                    }
                    break;
                case 39 :
                    // InternalRDL.g:3163:3: (enumLiteral_38= 'activehigh' )
                    {
                    // InternalRDL.g:3163:3: (enumLiteral_38= 'activehigh' )
                    // InternalRDL.g:3164:4: enumLiteral_38= 'activehigh'
                    {
                    enumLiteral_38=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getACTIVEHIGHEnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_38, grammarAccess.getPropertyAccess().getACTIVEHIGHEnumLiteralDeclaration_38());
                      			
                    }

                    }


                    }
                    break;
                case 40 :
                    // InternalRDL.g:3171:3: (enumLiteral_39= 'activelow' )
                    {
                    // InternalRDL.g:3171:3: (enumLiteral_39= 'activelow' )
                    // InternalRDL.g:3172:4: enumLiteral_39= 'activelow'
                    {
                    enumLiteral_39=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getACTIVELOWEnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_39, grammarAccess.getPropertyAccess().getACTIVELOWEnumLiteralDeclaration_39());
                      			
                    }

                    }


                    }
                    break;
                case 41 :
                    // InternalRDL.g:3179:3: (enumLiteral_40= 'singlepulse' )
                    {
                    // InternalRDL.g:3179:3: (enumLiteral_40= 'singlepulse' )
                    // InternalRDL.g:3180:4: enumLiteral_40= 'singlepulse'
                    {
                    enumLiteral_40=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSINGLEPULSEEnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_40, grammarAccess.getPropertyAccess().getSINGLEPULSEEnumLiteralDeclaration_40());
                      			
                    }

                    }


                    }
                    break;
                case 42 :
                    // InternalRDL.g:3187:3: (enumLiteral_41= 'underflow' )
                    {
                    // InternalRDL.g:3187:3: (enumLiteral_41= 'underflow' )
                    // InternalRDL.g:3188:4: enumLiteral_41= 'underflow'
                    {
                    enumLiteral_41=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getUNDERFLOWEnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_41, grammarAccess.getPropertyAccess().getUNDERFLOWEnumLiteralDeclaration_41());
                      			
                    }

                    }


                    }
                    break;
                case 43 :
                    // InternalRDL.g:3195:3: (enumLiteral_42= 'incr' )
                    {
                    // InternalRDL.g:3195:3: (enumLiteral_42= 'incr' )
                    // InternalRDL.g:3196:4: enumLiteral_42= 'incr'
                    {
                    enumLiteral_42=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getINCREnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_42, grammarAccess.getPropertyAccess().getINCREnumLiteralDeclaration_42());
                      			
                    }

                    }


                    }
                    break;
                case 44 :
                    // InternalRDL.g:3203:3: (enumLiteral_43= 'decr' )
                    {
                    // InternalRDL.g:3203:3: (enumLiteral_43= 'decr' )
                    // InternalRDL.g:3204:4: enumLiteral_43= 'decr'
                    {
                    enumLiteral_43=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDECREnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_43, grammarAccess.getPropertyAccess().getDECREnumLiteralDeclaration_43());
                      			
                    }

                    }


                    }
                    break;
                case 45 :
                    // InternalRDL.g:3211:3: (enumLiteral_44= 'incrwidth' )
                    {
                    // InternalRDL.g:3211:3: (enumLiteral_44= 'incrwidth' )
                    // InternalRDL.g:3212:4: enumLiteral_44= 'incrwidth'
                    {
                    enumLiteral_44=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getINCRWIDTHEnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_44, grammarAccess.getPropertyAccess().getINCRWIDTHEnumLiteralDeclaration_44());
                      			
                    }

                    }


                    }
                    break;
                case 46 :
                    // InternalRDL.g:3219:3: (enumLiteral_45= 'decrwidth' )
                    {
                    // InternalRDL.g:3219:3: (enumLiteral_45= 'decrwidth' )
                    // InternalRDL.g:3220:4: enumLiteral_45= 'decrwidth'
                    {
                    enumLiteral_45=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDECRWIDTHEnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_45, grammarAccess.getPropertyAccess().getDECRWIDTHEnumLiteralDeclaration_45());
                      			
                    }

                    }


                    }
                    break;
                case 47 :
                    // InternalRDL.g:3227:3: (enumLiteral_46= 'incrvalue' )
                    {
                    // InternalRDL.g:3227:3: (enumLiteral_46= 'incrvalue' )
                    // InternalRDL.g:3228:4: enumLiteral_46= 'incrvalue'
                    {
                    enumLiteral_46=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getINCRVALUEEnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_46, grammarAccess.getPropertyAccess().getINCRVALUEEnumLiteralDeclaration_46());
                      			
                    }

                    }


                    }
                    break;
                case 48 :
                    // InternalRDL.g:3235:3: (enumLiteral_47= 'decrvalue' )
                    {
                    // InternalRDL.g:3235:3: (enumLiteral_47= 'decrvalue' )
                    // InternalRDL.g:3236:4: enumLiteral_47= 'decrvalue'
                    {
                    enumLiteral_47=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDECRVALUEEnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_47, grammarAccess.getPropertyAccess().getDECRVALUEEnumLiteralDeclaration_47());
                      			
                    }

                    }


                    }
                    break;
                case 49 :
                    // InternalRDL.g:3243:3: (enumLiteral_48= 'saturate' )
                    {
                    // InternalRDL.g:3243:3: (enumLiteral_48= 'saturate' )
                    // InternalRDL.g:3244:4: enumLiteral_48= 'saturate'
                    {
                    enumLiteral_48=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSATURATEEnumLiteralDeclaration_48().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_48, grammarAccess.getPropertyAccess().getSATURATEEnumLiteralDeclaration_48());
                      			
                    }

                    }


                    }
                    break;
                case 50 :
                    // InternalRDL.g:3251:3: (enumLiteral_49= 'decrsaturate' )
                    {
                    // InternalRDL.g:3251:3: (enumLiteral_49= 'decrsaturate' )
                    // InternalRDL.g:3252:4: enumLiteral_49= 'decrsaturate'
                    {
                    enumLiteral_49=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDECRSATURATEEnumLiteralDeclaration_49().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_49, grammarAccess.getPropertyAccess().getDECRSATURATEEnumLiteralDeclaration_49());
                      			
                    }

                    }


                    }
                    break;
                case 51 :
                    // InternalRDL.g:3259:3: (enumLiteral_50= 'threshold' )
                    {
                    // InternalRDL.g:3259:3: (enumLiteral_50= 'threshold' )
                    // InternalRDL.g:3260:4: enumLiteral_50= 'threshold'
                    {
                    enumLiteral_50=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getTHRESHOLDEnumLiteralDeclaration_50().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_50, grammarAccess.getPropertyAccess().getTHRESHOLDEnumLiteralDeclaration_50());
                      			
                    }

                    }


                    }
                    break;
                case 52 :
                    // InternalRDL.g:3267:3: (enumLiteral_51= 'decrthreshold' )
                    {
                    // InternalRDL.g:3267:3: (enumLiteral_51= 'decrthreshold' )
                    // InternalRDL.g:3268:4: enumLiteral_51= 'decrthreshold'
                    {
                    enumLiteral_51=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDECRTHRESHOLDEnumLiteralDeclaration_51().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_51, grammarAccess.getPropertyAccess().getDECRTHRESHOLDEnumLiteralDeclaration_51());
                      			
                    }

                    }


                    }
                    break;
                case 53 :
                    // InternalRDL.g:3275:3: (enumLiteral_52= 'dontcompare' )
                    {
                    // InternalRDL.g:3275:3: (enumLiteral_52= 'dontcompare' )
                    // InternalRDL.g:3276:4: enumLiteral_52= 'dontcompare'
                    {
                    enumLiteral_52=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDONTCOMPAREEnumLiteralDeclaration_52().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_52, grammarAccess.getPropertyAccess().getDONTCOMPAREEnumLiteralDeclaration_52());
                      			
                    }

                    }


                    }
                    break;
                case 54 :
                    // InternalRDL.g:3283:3: (enumLiteral_53= 'donttest' )
                    {
                    // InternalRDL.g:3283:3: (enumLiteral_53= 'donttest' )
                    // InternalRDL.g:3284:4: enumLiteral_53= 'donttest'
                    {
                    enumLiteral_53=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getDONTTESTEnumLiteralDeclaration_53().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_53, grammarAccess.getPropertyAccess().getDONTTESTEnumLiteralDeclaration_53());
                      			
                    }

                    }


                    }
                    break;
                case 55 :
                    // InternalRDL.g:3291:3: (enumLiteral_54= 'internal' )
                    {
                    // InternalRDL.g:3291:3: (enumLiteral_54= 'internal' )
                    // InternalRDL.g:3292:4: enumLiteral_54= 'internal'
                    {
                    enumLiteral_54=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getINTERNALEnumLiteralDeclaration_54().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_54, grammarAccess.getPropertyAccess().getINTERNALEnumLiteralDeclaration_54());
                      			
                    }

                    }


                    }
                    break;
                case 56 :
                    // InternalRDL.g:3299:3: (enumLiteral_55= 'alignment' )
                    {
                    // InternalRDL.g:3299:3: (enumLiteral_55= 'alignment' )
                    // InternalRDL.g:3300:4: enumLiteral_55= 'alignment'
                    {
                    enumLiteral_55=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getALIGNMENTEnumLiteralDeclaration_55().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_55, grammarAccess.getPropertyAccess().getALIGNMENTEnumLiteralDeclaration_55());
                      			
                    }

                    }


                    }
                    break;
                case 57 :
                    // InternalRDL.g:3307:3: (enumLiteral_56= 'regwidth' )
                    {
                    // InternalRDL.g:3307:3: (enumLiteral_56= 'regwidth' )
                    // InternalRDL.g:3308:4: enumLiteral_56= 'regwidth'
                    {
                    enumLiteral_56=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getREGWIDTHEnumLiteralDeclaration_56().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_56, grammarAccess.getPropertyAccess().getREGWIDTHEnumLiteralDeclaration_56());
                      			
                    }

                    }


                    }
                    break;
                case 58 :
                    // InternalRDL.g:3315:3: (enumLiteral_57= 'fieldwidth' )
                    {
                    // InternalRDL.g:3315:3: (enumLiteral_57= 'fieldwidth' )
                    // InternalRDL.g:3316:4: enumLiteral_57= 'fieldwidth'
                    {
                    enumLiteral_57=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getFIELDWIDTHEnumLiteralDeclaration_57().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_57, grammarAccess.getPropertyAccess().getFIELDWIDTHEnumLiteralDeclaration_57());
                      			
                    }

                    }


                    }
                    break;
                case 59 :
                    // InternalRDL.g:3323:3: (enumLiteral_58= 'signalwidth' )
                    {
                    // InternalRDL.g:3323:3: (enumLiteral_58= 'signalwidth' )
                    // InternalRDL.g:3324:4: enumLiteral_58= 'signalwidth'
                    {
                    enumLiteral_58=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSIGNALWIDTHEnumLiteralDeclaration_58().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_58, grammarAccess.getPropertyAccess().getSIGNALWIDTHEnumLiteralDeclaration_58());
                      			
                    }

                    }


                    }
                    break;
                case 60 :
                    // InternalRDL.g:3331:3: (enumLiteral_59= 'accesswidth' )
                    {
                    // InternalRDL.g:3331:3: (enumLiteral_59= 'accesswidth' )
                    // InternalRDL.g:3332:4: enumLiteral_59= 'accesswidth'
                    {
                    enumLiteral_59=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getACCESSWIDTHEnumLiteralDeclaration_59().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_59, grammarAccess.getPropertyAccess().getACCESSWIDTHEnumLiteralDeclaration_59());
                      			
                    }

                    }


                    }
                    break;
                case 61 :
                    // InternalRDL.g:3339:3: (enumLiteral_60= 'sw' )
                    {
                    // InternalRDL.g:3339:3: (enumLiteral_60= 'sw' )
                    // InternalRDL.g:3340:4: enumLiteral_60= 'sw'
                    {
                    enumLiteral_60=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getSWEnumLiteralDeclaration_60().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_60, grammarAccess.getPropertyAccess().getSWEnumLiteralDeclaration_60());
                      			
                    }

                    }


                    }
                    break;
                case 62 :
                    // InternalRDL.g:3347:3: (enumLiteral_61= 'hw' )
                    {
                    // InternalRDL.g:3347:3: (enumLiteral_61= 'hw' )
                    // InternalRDL.g:3348:4: enumLiteral_61= 'hw'
                    {
                    enumLiteral_61=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHWEnumLiteralDeclaration_61().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_61, grammarAccess.getPropertyAccess().getHWEnumLiteralDeclaration_61());
                      			
                    }

                    }


                    }
                    break;
                case 63 :
                    // InternalRDL.g:3355:3: (enumLiteral_62= 'addressing' )
                    {
                    // InternalRDL.g:3355:3: (enumLiteral_62= 'addressing' )
                    // InternalRDL.g:3356:4: enumLiteral_62= 'addressing'
                    {
                    enumLiteral_62=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getADDRESSINGEnumLiteralDeclaration_62().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_62, grammarAccess.getPropertyAccess().getADDRESSINGEnumLiteralDeclaration_62());
                      			
                    }

                    }


                    }
                    break;
                case 64 :
                    // InternalRDL.g:3363:3: (enumLiteral_63= 'precedence' )
                    {
                    // InternalRDL.g:3363:3: (enumLiteral_63= 'precedence' )
                    // InternalRDL.g:3364:4: enumLiteral_63= 'precedence'
                    {
                    enumLiteral_63=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getPRECEDENCEEnumLiteralDeclaration_63().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_63, grammarAccess.getPropertyAccess().getPRECEDENCEEnumLiteralDeclaration_63());
                      			
                    }

                    }


                    }
                    break;
                case 65 :
                    // InternalRDL.g:3371:3: (enumLiteral_64= 'encode' )
                    {
                    // InternalRDL.g:3371:3: (enumLiteral_64= 'encode' )
                    // InternalRDL.g:3372:4: enumLiteral_64= 'encode'
                    {
                    enumLiteral_64=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getENCODEEnumLiteralDeclaration_64().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_64, grammarAccess.getPropertyAccess().getENCODEEnumLiteralDeclaration_64());
                      			
                    }

                    }


                    }
                    break;
                case 66 :
                    // InternalRDL.g:3379:3: (enumLiteral_65= 'resetsignal' )
                    {
                    // InternalRDL.g:3379:3: (enumLiteral_65= 'resetsignal' )
                    // InternalRDL.g:3380:4: enumLiteral_65= 'resetsignal'
                    {
                    enumLiteral_65=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getRESETSIGNALEnumLiteralDeclaration_65().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_65, grammarAccess.getPropertyAccess().getRESETSIGNALEnumLiteralDeclaration_65());
                      			
                    }

                    }


                    }
                    break;
                case 67 :
                    // InternalRDL.g:3387:3: (enumLiteral_66= 'clock' )
                    {
                    // InternalRDL.g:3387:3: (enumLiteral_66= 'clock' )
                    // InternalRDL.g:3388:4: enumLiteral_66= 'clock'
                    {
                    enumLiteral_66=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getCLOCKEnumLiteralDeclaration_66().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_66, grammarAccess.getPropertyAccess().getCLOCKEnumLiteralDeclaration_66());
                      			
                    }

                    }


                    }
                    break;
                case 68 :
                    // InternalRDL.g:3395:3: (enumLiteral_67= 'mask' )
                    {
                    // InternalRDL.g:3395:3: (enumLiteral_67= 'mask' )
                    // InternalRDL.g:3396:4: enumLiteral_67= 'mask'
                    {
                    enumLiteral_67=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getMASKEnumLiteralDeclaration_67().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_67, grammarAccess.getPropertyAccess().getMASKEnumLiteralDeclaration_67());
                      			
                    }

                    }


                    }
                    break;
                case 69 :
                    // InternalRDL.g:3403:3: (enumLiteral_68= 'enable' )
                    {
                    // InternalRDL.g:3403:3: (enumLiteral_68= 'enable' )
                    // InternalRDL.g:3404:4: enumLiteral_68= 'enable'
                    {
                    enumLiteral_68=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getENABLEEnumLiteralDeclaration_68().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_68, grammarAccess.getPropertyAccess().getENABLEEnumLiteralDeclaration_68());
                      			
                    }

                    }


                    }
                    break;
                case 70 :
                    // InternalRDL.g:3411:3: (enumLiteral_69= 'hwenable' )
                    {
                    // InternalRDL.g:3411:3: (enumLiteral_69= 'hwenable' )
                    // InternalRDL.g:3412:4: enumLiteral_69= 'hwenable'
                    {
                    enumLiteral_69=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHWENABLEEnumLiteralDeclaration_69().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_69, grammarAccess.getPropertyAccess().getHWENABLEEnumLiteralDeclaration_69());
                      			
                    }

                    }


                    }
                    break;
                case 71 :
                    // InternalRDL.g:3419:3: (enumLiteral_70= 'hwmask' )
                    {
                    // InternalRDL.g:3419:3: (enumLiteral_70= 'hwmask' )
                    // InternalRDL.g:3420:4: enumLiteral_70= 'hwmask'
                    {
                    enumLiteral_70=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHWMASKEnumLiteralDeclaration_70().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_70, grammarAccess.getPropertyAccess().getHWMASKEnumLiteralDeclaration_70());
                      			
                    }

                    }


                    }
                    break;
                case 72 :
                    // InternalRDL.g:3427:3: (enumLiteral_71= 'haltmask' )
                    {
                    // InternalRDL.g:3427:3: (enumLiteral_71= 'haltmask' )
                    // InternalRDL.g:3428:4: enumLiteral_71= 'haltmask'
                    {
                    enumLiteral_71=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHALTMASKEnumLiteralDeclaration_71().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_71, grammarAccess.getPropertyAccess().getHALTMASKEnumLiteralDeclaration_71());
                      			
                    }

                    }


                    }
                    break;
                case 73 :
                    // InternalRDL.g:3435:3: (enumLiteral_72= 'haltenable' )
                    {
                    // InternalRDL.g:3435:3: (enumLiteral_72= 'haltenable' )
                    // InternalRDL.g:3436:4: enumLiteral_72= 'haltenable'
                    {
                    enumLiteral_72=(Token)match(input,118,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHALTENABLEEnumLiteralDeclaration_72().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_72, grammarAccess.getPropertyAccess().getHALTENABLEEnumLiteralDeclaration_72());
                      			
                    }

                    }


                    }
                    break;
                case 74 :
                    // InternalRDL.g:3443:3: (enumLiteral_73= 'halt' )
                    {
                    // InternalRDL.g:3443:3: (enumLiteral_73= 'halt' )
                    // InternalRDL.g:3444:4: enumLiteral_73= 'halt'
                    {
                    enumLiteral_73=(Token)match(input,119,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getHALTEnumLiteralDeclaration_73().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_73, grammarAccess.getPropertyAccess().getHALTEnumLiteralDeclaration_73());
                      			
                    }

                    }


                    }
                    break;
                case 75 :
                    // InternalRDL.g:3451:3: (enumLiteral_74= 'next' )
                    {
                    // InternalRDL.g:3451:3: (enumLiteral_74= 'next' )
                    // InternalRDL.g:3452:4: enumLiteral_74= 'next'
                    {
                    enumLiteral_74=(Token)match(input,120,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyAccess().getNEXTEnumLiteralDeclaration_74().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_74, grammarAccess.getPropertyAccess().getNEXTEnumLiteralDeclaration_74());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "ruleRValueConstant"
    // InternalRDL.g:3462:1: ruleRValueConstant returns [Enumerator current=null] : ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) ) ;
    public final Enumerator ruleRValueConstant() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;


        	enterRule();

        try {
            // InternalRDL.g:3468:2: ( ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) ) )
            // InternalRDL.g:3469:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) )
            {
            // InternalRDL.g:3469:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) )
            int alt46=13;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt46=1;
                }
                break;
            case 20:
                {
                alt46=2;
                }
                break;
            case 21:
                {
                alt46=3;
                }
                break;
            case 122:
                {
                alt46=4;
                }
                break;
            case 123:
                {
                alt46=5;
                }
                break;
            case 124:
                {
                alt46=6;
                }
                break;
            case 125:
                {
                alt46=7;
                }
                break;
            case 126:
                {
                alt46=8;
                }
                break;
            case 127:
                {
                alt46=9;
                }
                break;
            case 128:
                {
                alt46=10;
                }
                break;
            case 129:
                {
                alt46=11;
                }
                break;
            case 107:
                {
                alt46=12;
                }
                break;
            case 106:
                {
                alt46=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalRDL.g:3470:3: (enumLiteral_0= 'UNDEFINED' )
                    {
                    // InternalRDL.g:3470:3: (enumLiteral_0= 'UNDEFINED' )
                    // InternalRDL.g:3471:4: enumLiteral_0= 'UNDEFINED'
                    {
                    enumLiteral_0=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getUNDEFINEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRValueConstantAccess().getUNDEFINEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:3478:3: (enumLiteral_1= 'true' )
                    {
                    // InternalRDL.g:3478:3: (enumLiteral_1= 'true' )
                    // InternalRDL.g:3479:4: enumLiteral_1= 'true'
                    {
                    enumLiteral_1=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getTRUEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRValueConstantAccess().getTRUEEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:3486:3: (enumLiteral_2= 'false' )
                    {
                    // InternalRDL.g:3486:3: (enumLiteral_2= 'false' )
                    // InternalRDL.g:3487:4: enumLiteral_2= 'false'
                    {
                    enumLiteral_2=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getFALSEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRValueConstantAccess().getFALSEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:3494:3: (enumLiteral_3= 'rw' )
                    {
                    // InternalRDL.g:3494:3: (enumLiteral_3= 'rw' )
                    // InternalRDL.g:3495:4: enumLiteral_3= 'rw'
                    {
                    enumLiteral_3=(Token)match(input,122,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getRWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRValueConstantAccess().getRWEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:3502:3: (enumLiteral_4= 'wr' )
                    {
                    // InternalRDL.g:3502:3: (enumLiteral_4= 'wr' )
                    // InternalRDL.g:3503:4: enumLiteral_4= 'wr'
                    {
                    enumLiteral_4=(Token)match(input,123,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getWREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRValueConstantAccess().getWREnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:3510:3: (enumLiteral_5= 'r' )
                    {
                    // InternalRDL.g:3510:3: (enumLiteral_5= 'r' )
                    // InternalRDL.g:3511:4: enumLiteral_5= 'r'
                    {
                    enumLiteral_5=(Token)match(input,124,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRValueConstantAccess().getREnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRDL.g:3518:3: (enumLiteral_6= 'w' )
                    {
                    // InternalRDL.g:3518:3: (enumLiteral_6= 'w' )
                    // InternalRDL.g:3519:4: enumLiteral_6= 'w'
                    {
                    enumLiteral_6=(Token)match(input,125,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getWEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRValueConstantAccess().getWEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalRDL.g:3526:3: (enumLiteral_7= 'na' )
                    {
                    // InternalRDL.g:3526:3: (enumLiteral_7= 'na' )
                    // InternalRDL.g:3527:4: enumLiteral_7= 'na'
                    {
                    enumLiteral_7=(Token)match(input,126,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getNAEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getRValueConstantAccess().getNAEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalRDL.g:3534:3: (enumLiteral_8= 'compact' )
                    {
                    // InternalRDL.g:3534:3: (enumLiteral_8= 'compact' )
                    // InternalRDL.g:3535:4: enumLiteral_8= 'compact'
                    {
                    enumLiteral_8=(Token)match(input,127,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getCOMPACTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getRValueConstantAccess().getCOMPACTEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalRDL.g:3542:3: (enumLiteral_9= 'regalign' )
                    {
                    // InternalRDL.g:3542:3: (enumLiteral_9= 'regalign' )
                    // InternalRDL.g:3543:4: enumLiteral_9= 'regalign'
                    {
                    enumLiteral_9=(Token)match(input,128,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getREGALIGNEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getRValueConstantAccess().getREGALIGNEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalRDL.g:3550:3: (enumLiteral_10= 'fullalign' )
                    {
                    // InternalRDL.g:3550:3: (enumLiteral_10= 'fullalign' )
                    // InternalRDL.g:3551:4: enumLiteral_10= 'fullalign'
                    {
                    enumLiteral_10=(Token)match(input,129,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getFULLALIGNEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getRValueConstantAccess().getFULLALIGNEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalRDL.g:3558:3: (enumLiteral_11= 'hw' )
                    {
                    // InternalRDL.g:3558:3: (enumLiteral_11= 'hw' )
                    // InternalRDL.g:3559:4: enumLiteral_11= 'hw'
                    {
                    enumLiteral_11=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getHWEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getRValueConstantAccess().getHWEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalRDL.g:3566:3: (enumLiteral_12= 'sw' )
                    {
                    // InternalRDL.g:3566:3: (enumLiteral_12= 'sw' )
                    // InternalRDL.g:3567:4: enumLiteral_12= 'sw'
                    {
                    enumLiteral_12=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRValueConstantAccess().getSWEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getRValueConstantAccess().getSWEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRValueConstant"


    // $ANTLR start "rulePropertyModifier"
    // InternalRDL.g:3577:1: rulePropertyModifier returns [Enumerator current=null] : ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) ) ;
    public final Enumerator rulePropertyModifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalRDL.g:3583:2: ( ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) ) )
            // InternalRDL.g:3584:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) )
            {
            // InternalRDL.g:3584:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) )
            int alt47=6;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt47=1;
                }
                break;
            case 130:
                {
                alt47=2;
                }
                break;
            case 131:
                {
                alt47=3;
                }
                break;
            case 132:
                {
                alt47=4;
                }
                break;
            case 133:
                {
                alt47=5;
                }
                break;
            case 134:
                {
                alt47=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalRDL.g:3585:3: (enumLiteral_0= 'UNDEFINED' )
                    {
                    // InternalRDL.g:3585:3: (enumLiteral_0= 'UNDEFINED' )
                    // InternalRDL.g:3586:4: enumLiteral_0= 'UNDEFINED'
                    {
                    enumLiteral_0=(Token)match(input,121,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyModifierAccess().getUNDEFINEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPropertyModifierAccess().getUNDEFINEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:3593:3: (enumLiteral_1= 'posedge' )
                    {
                    // InternalRDL.g:3593:3: (enumLiteral_1= 'posedge' )
                    // InternalRDL.g:3594:4: enumLiteral_1= 'posedge'
                    {
                    enumLiteral_1=(Token)match(input,130,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyModifierAccess().getPOSEDGEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPropertyModifierAccess().getPOSEDGEEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:3601:3: (enumLiteral_2= 'negedge' )
                    {
                    // InternalRDL.g:3601:3: (enumLiteral_2= 'negedge' )
                    // InternalRDL.g:3602:4: enumLiteral_2= 'negedge'
                    {
                    enumLiteral_2=(Token)match(input,131,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyModifierAccess().getNEGEDGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getPropertyModifierAccess().getNEGEDGEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:3609:3: (enumLiteral_3= 'bothedge' )
                    {
                    // InternalRDL.g:3609:3: (enumLiteral_3= 'bothedge' )
                    // InternalRDL.g:3610:4: enumLiteral_3= 'bothedge'
                    {
                    enumLiteral_3=(Token)match(input,132,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyModifierAccess().getBOTHEDGEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getPropertyModifierAccess().getBOTHEDGEEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:3617:3: (enumLiteral_4= 'level' )
                    {
                    // InternalRDL.g:3617:3: (enumLiteral_4= 'level' )
                    // InternalRDL.g:3618:4: enumLiteral_4= 'level'
                    {
                    enumLiteral_4=(Token)match(input,133,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyModifierAccess().getLEVELEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getPropertyModifierAccess().getLEVELEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:3625:3: (enumLiteral_5= 'nonsticky' )
                    {
                    // InternalRDL.g:3625:3: (enumLiteral_5= 'nonsticky' )
                    // InternalRDL.g:3626:4: enumLiteral_5= 'nonsticky'
                    {
                    enumLiteral_5=(Token)match(input,134,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPropertyModifierAccess().getNONSTICKYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getPropertyModifierAccess().getNONSTICKYEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyModifier"

    // $ANTLR start synpred2_InternalRDL
    public final void synpred2_InternalRDL_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        EObject lv_componentDefinitions_1_0 = null;


        // InternalRDL.g:106:3: ( ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' ) )
        // InternalRDL.g:106:3: ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' )
        {
        // InternalRDL.g:106:3: ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' )
        // InternalRDL.g:107:4: ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';'
        {
        // InternalRDL.g:107:4: ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) )
        // InternalRDL.g:108:5: (lv_componentDefinitions_1_0= ruleComponentDefinition )
        {
        // InternalRDL.g:108:5: (lv_componentDefinitions_1_0= ruleComponentDefinition )
        // InternalRDL.g:109:6: lv_componentDefinitions_1_0= ruleComponentDefinition
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRootAccess().getComponentDefinitionsComponentDefinitionParserRuleCall_1_0_0());
          					
        }
        pushFollow(FOLLOW_4);
        lv_componentDefinitions_1_0=ruleComponentDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_2=(Token)match(input,12,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalRDL

    // $ANTLR start synpred4_InternalRDL
    public final void synpred4_InternalRDL_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        EObject lv_instantiations_5_0 = null;


        // InternalRDL.g:158:3: ( ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) )
        // InternalRDL.g:158:3: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
        {
        // InternalRDL.g:158:3: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
        // InternalRDL.g:159:4: ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';'
        {
        // InternalRDL.g:159:4: ( (lv_instantiations_5_0= ruleInstantiation ) )
        // InternalRDL.g:160:5: (lv_instantiations_5_0= ruleInstantiation )
        {
        // InternalRDL.g:160:5: (lv_instantiations_5_0= ruleInstantiation )
        // InternalRDL.g:161:6: lv_instantiations_5_0= ruleInstantiation
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRootAccess().getInstantiationsInstantiationParserRuleCall_3_0_0());
          					
        }
        pushFollow(FOLLOW_4);
        lv_instantiations_5_0=ruleInstantiation();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_6=(Token)match(input,12,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalRDL

    // $ANTLR start synpred5_InternalRDL
    public final void synpred5_InternalRDL_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        EObject lv_propertyAssignments_7_0 = null;


        // InternalRDL.g:184:3: ( ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) )
        // InternalRDL.g:184:3: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
        {
        // InternalRDL.g:184:3: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
        // InternalRDL.g:185:4: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';'
        {
        // InternalRDL.g:185:4: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) )
        // InternalRDL.g:186:5: (lv_propertyAssignments_7_0= rulePropertyAssignment )
        {
        // InternalRDL.g:186:5: (lv_propertyAssignments_7_0= rulePropertyAssignment )
        // InternalRDL.g:187:6: lv_propertyAssignments_7_0= rulePropertyAssignment
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRootAccess().getPropertyAssignmentsPropertyAssignmentParserRuleCall_4_0_0());
          					
        }
        pushFollow(FOLLOW_4);
        lv_propertyAssignments_7_0=rulePropertyAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,12,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalRDL

    // $ANTLR start synpred19_InternalRDL
    public final void synpred19_InternalRDL_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        EObject lv_componentDefinitions_3_0 = null;


        // InternalRDL.g:941:4: ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) )
        // InternalRDL.g:941:4: ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' )
        {
        // InternalRDL.g:941:4: ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' )
        // InternalRDL.g:942:5: ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';'
        {
        // InternalRDL.g:942:5: ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) )
        // InternalRDL.g:943:6: (lv_componentDefinitions_3_0= ruleComponentDefinition )
        {
        // InternalRDL.g:943:6: (lv_componentDefinitions_3_0= ruleComponentDefinition )
        // InternalRDL.g:944:7: lv_componentDefinitions_3_0= ruleComponentDefinition
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getComponentDefinitionAccess().getComponentDefinitionsComponentDefinitionParserRuleCall_3_0_0_0());
          						
        }
        pushFollow(FOLLOW_4);
        lv_componentDefinitions_3_0=ruleComponentDefinition();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,12,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred19_InternalRDL

    // $ANTLR start synpred20_InternalRDL
    public final void synpred20_InternalRDL_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        EObject lv_instantiations_5_0 = null;


        // InternalRDL.g:967:4: ( ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) )
        // InternalRDL.g:967:4: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
        {
        // InternalRDL.g:967:4: ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' )
        // InternalRDL.g:968:5: ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';'
        {
        // InternalRDL.g:968:5: ( (lv_instantiations_5_0= ruleInstantiation ) )
        // InternalRDL.g:969:6: (lv_instantiations_5_0= ruleInstantiation )
        {
        // InternalRDL.g:969:6: (lv_instantiations_5_0= ruleInstantiation )
        // InternalRDL.g:970:7: lv_instantiations_5_0= ruleInstantiation
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getComponentDefinitionAccess().getInstantiationsInstantiationParserRuleCall_3_1_0_0());
          						
        }
        pushFollow(FOLLOW_4);
        lv_instantiations_5_0=ruleInstantiation();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_6=(Token)match(input,12,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalRDL

    // $ANTLR start synpred21_InternalRDL
    public final void synpred21_InternalRDL_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        EObject lv_propertyAssignments_7_0 = null;


        // InternalRDL.g:993:4: ( ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) )
        // InternalRDL.g:993:4: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
        {
        // InternalRDL.g:993:4: ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' )
        // InternalRDL.g:994:5: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';'
        {
        // InternalRDL.g:994:5: ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) )
        // InternalRDL.g:995:6: (lv_propertyAssignments_7_0= rulePropertyAssignment )
        {
        // InternalRDL.g:995:6: (lv_propertyAssignments_7_0= rulePropertyAssignment )
        // InternalRDL.g:996:7: lv_propertyAssignments_7_0= rulePropertyAssignment
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getComponentDefinitionAccess().getPropertyAssignmentsPropertyAssignmentParserRuleCall_3_2_0_0());
          						
        }
        pushFollow(FOLLOW_4);
        lv_propertyAssignments_7_0=rulePropertyAssignment();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,12,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalRDL

    // Delegated rules

    public final boolean synpred20_InternalRDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalRDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalRDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalRDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalRDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalRDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalRDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalRDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalRDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalRDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalRDL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalRDL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\140\uffff";
    static final String dfa_2s = "\1\1\137\uffff";
    static final String dfa_3s = "\1\5\2\uffff\5\0\2\uffff\1\0\1\uffff\1\0\123\uffff";
    static final String dfa_4s = "\1\u0086\2\uffff\5\0\2\uffff\1\0\1\uffff\1\0\123\uffff";
    static final String dfa_5s = "\1\uffff\1\7\1\1\5\uffff\1\3\1\4\3\uffff\1\5\120\uffff\1\6\1\2";
    static final String dfa_6s = "\3\uffff\1\0\1\1\1\2\1\3\1\4\2\uffff\1\5\1\uffff\1\6\123\uffff}>";
    static final String[] dfa_7s = {
            "\1\14\7\uffff\1\2\1\136\4\uffff\1\15\4\uffff\1\11\11\uffff\1\10\2\15\1\11\1\12\3\uffff\1\4\1\6\1\5\1\7\1\uffff\1\3\1\uffff\111\15\10\uffff\5\15",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 85:2: ( ( (lv_includes_0_0= ruleInclude ) ) | ( ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) otherlv_2= ';' ) | ( ( (lv_enumDefinitions_3_0= ruleEnumDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_propertyDefinitions_9_0= rulePropertyDefinition ) ) otherlv_10= ';' ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRDL()) ) {s = 95;}

                        else if ( (synpred4_InternalRDL()) ) {s = 9;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRDL()) ) {s = 95;}

                        else if ( (synpred4_InternalRDL()) ) {s = 9;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRDL()) ) {s = 95;}

                        else if ( (synpred4_InternalRDL()) ) {s = 9;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRDL()) ) {s = 95;}

                        else if ( (synpred4_InternalRDL()) ) {s = 9;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRDL()) ) {s = 95;}

                        else if ( (synpred4_InternalRDL()) ) {s = 9;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_10 = input.LA(1);

                         
                        int index1_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalRDL()) ) {s = 9;}

                        else if ( (synpred5_InternalRDL()) ) {s = 13;}

                         
                        input.seek(index1_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_12 = input.LA(1);

                         
                        int index1_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalRDL()) ) {s = 9;}

                        else if ( (synpred5_InternalRDL()) ) {s = 13;}

                         
                        input.seek(index1_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\136\uffff";
    static final String dfa_9s = "\1\5\1\uffff\5\0\1\uffff\1\0\1\uffff\1\0\123\uffff";
    static final String dfa_10s = "\1\u0086\1\uffff\5\0\1\uffff\1\0\1\uffff\1\0\123\uffff";
    static final String dfa_11s = "\1\uffff\1\5\5\uffff\1\2\3\uffff\1\3\120\uffff\1\4\1\1";
    static final String dfa_12s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\uffff\1\5\1\uffff\1\6\123\uffff}>";
    static final String[] dfa_13s = {
            "\1\12\14\uffff\1\1\1\13\4\uffff\1\7\11\uffff\1\134\2\13\1\7\1\10\3\uffff\1\3\1\5\1\4\1\6\1\uffff\1\2\1\uffff\111\13\10\uffff\5\13",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 940:3: ( ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) otherlv_4= ';' ) | ( ( (lv_instantiations_5_0= ruleInstantiation ) ) otherlv_6= ';' ) | ( ( (lv_propertyAssignments_7_0= rulePropertyAssignment ) ) otherlv_8= ';' ) | ( ( (lv_enumDefinitions_9_0= ruleEnumDefinition ) ) otherlv_10= ';' ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalRDL()) ) {s = 93;}

                        else if ( (synpred20_InternalRDL()) ) {s = 7;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalRDL()) ) {s = 93;}

                        else if ( (synpred20_InternalRDL()) ) {s = 7;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_4 = input.LA(1);

                         
                        int index11_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalRDL()) ) {s = 93;}

                        else if ( (synpred20_InternalRDL()) ) {s = 7;}

                         
                        input.seek(index11_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalRDL()) ) {s = 93;}

                        else if ( (synpred20_InternalRDL()) ) {s = 7;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalRDL()) ) {s = 93;}

                        else if ( (synpred20_InternalRDL()) ) {s = 7;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_8 = input.LA(1);

                         
                        int index11_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalRDL()) ) {s = 7;}

                        else if ( (synpred21_InternalRDL()) ) {s = 11;}

                         
                        input.seek(index11_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA11_10 = input.LA(1);

                         
                        int index11_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalRDL()) ) {s = 7;}

                        else if ( (synpred21_InternalRDL()) ) {s = 11;}

                         
                        input.seek(index11_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFEBC7C01086022L,0x03FFFFFFFFFFFFFFL,0x000000000000007CL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0xFFFEBC7C01087022L,0x03FFFFFFFFFFFFFFL,0x000000000000007CL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000490000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00007F8000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000004D0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000410000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000300050L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001BC0000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFEBC7C010C0020L,0x03FFFFFFFFFFFFFFL,0x000000000000007CL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000006000000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000003C020002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000001C020002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0xFFFE005800000000L,0x03FFFFFFFFFFFFFFL,0x000000000000007CL});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000308070L,0xFE000C0000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xFFFE005800000020L,0x03FFFFFFFFFFFFFFL,0x000000000000007CL});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000001800040000L});

}