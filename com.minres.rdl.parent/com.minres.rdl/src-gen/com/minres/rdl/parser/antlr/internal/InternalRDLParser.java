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

@SuppressWarnings("all")
public class InternalRDLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STR", "RULE_ID", "RULE_NUM", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'`include'", "'property'", "'{'", "'type'", "'='", "';'", "'}'", "'default'", "'true'", "'false'", "'component'", "'|'", "'external'", "'internal'", "'alias'", "','", "'@'", "'+='", "'%='", "'['", "':'", "']'", "'->'", "'.'", "'enum'", "'name'", "'desc'", "'string'", "'number'", "'boolean'", "'addrmap'", "'reg'", "'regfile'", "'field'", "'ref'", "'signal'", "'all'", "'arbiter'", "'rset'", "'rclr'", "'woclr'", "'woset'", "'we'", "'wel'", "'swwe'", "'swwel'", "'hwset'", "'hwclr'", "'swmod'", "'swacc'", "'sticky'", "'stickybit'", "'intr'", "'anded'", "'ored'", "'xored'", "'counter'", "'overflow'", "'sharedextbus'", "'errextbus'", "'reset'", "'littleendian'", "'bigendian'", "'rsvdset'", "'rsvdsetX'", "'bridge'", "'shared'", "'msb0'", "'lsb0'", "'sync'", "'async'", "'cpuif_reset'", "'field_reset'", "'activehigh'", "'activelow'", "'singlepulse'", "'underflow'", "'incr'", "'decr'", "'incrwidth'", "'decrwidth'", "'incrvalue'", "'decrvalue'", "'saturate'", "'decrsaturate'", "'threshold'", "'decrthreshold'", "'dontcompare'", "'donttest'", "'alignment'", "'regwidth'", "'fieldwidth'", "'signalwidth'", "'accesswidth'", "'sw'", "'hw'", "'addressing'", "'precedence'", "'encode'", "'resetsignal'", "'clock'", "'mask'", "'enable'", "'hwenable'", "'hwmask'", "'haltmask'", "'haltenable'", "'halt'", "'next'", "'UNDEFINED'", "'rw'", "'wr'", "'r'", "'w'", "'na'", "'compact'", "'regalign'", "'fullalign'", "'posedge'", "'negedge'", "'bothedge'", "'level'", "'nonsticky'"
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
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__61=61;
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
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int RULE_NUM=6;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__10=10;
    public static final int T__98=98;
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
    // InternalRDL.g:65:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalRDL.g:65:45: (iv_ruleRoot= ruleRoot EOF )
            // InternalRDL.g:66:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:72:1: ruleRoot returns [EObject current=null] : ( ( (lv_includes_0_0= ruleInclude ) ) | ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) | ( (lv_enumDefinitions_2_0= ruleEnumDefinition ) ) | ( (lv_namedInstantiations_3_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_4_0= rulePropertyAssignment ) ) | ( (lv_propertyDefinitions_5_0= rulePropertyDefinition ) ) )* ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_includes_0_0 = null;

        EObject lv_componentDefinitions_1_0 = null;

        EObject lv_enumDefinitions_2_0 = null;

        EObject lv_namedInstantiations_3_0 = null;

        EObject lv_propertyAssignments_4_0 = null;

        EObject lv_propertyDefinitions_5_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:78:2: ( ( ( (lv_includes_0_0= ruleInclude ) ) | ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) | ( (lv_enumDefinitions_2_0= ruleEnumDefinition ) ) | ( (lv_namedInstantiations_3_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_4_0= rulePropertyAssignment ) ) | ( (lv_propertyDefinitions_5_0= rulePropertyDefinition ) ) )* )
            // InternalRDL.g:79:2: ( ( (lv_includes_0_0= ruleInclude ) ) | ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) | ( (lv_enumDefinitions_2_0= ruleEnumDefinition ) ) | ( (lv_namedInstantiations_3_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_4_0= rulePropertyAssignment ) ) | ( (lv_propertyDefinitions_5_0= rulePropertyDefinition ) ) )*
            {
            // InternalRDL.g:79:2: ( ( (lv_includes_0_0= ruleInclude ) ) | ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) | ( (lv_enumDefinitions_2_0= ruleEnumDefinition ) ) | ( (lv_namedInstantiations_3_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_4_0= rulePropertyAssignment ) ) | ( (lv_propertyDefinitions_5_0= rulePropertyDefinition ) ) )*
            loop1:
            do {
                int alt1=7;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalRDL.g:80:3: ( (lv_includes_0_0= ruleInclude ) )
            	    {
            	    // InternalRDL.g:80:3: ( (lv_includes_0_0= ruleInclude ) )
            	    // InternalRDL.g:81:4: (lv_includes_0_0= ruleInclude )
            	    {
            	    // InternalRDL.g:81:4: (lv_includes_0_0= ruleInclude )
            	    // InternalRDL.g:82:5: lv_includes_0_0= ruleInclude
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getIncludesIncludeParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_includes_0_0=ruleInclude();

            	    state._fsp--;


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
            	    break;
            	case 2 :
            	    // InternalRDL.g:100:3: ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) )
            	    {
            	    // InternalRDL.g:100:3: ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) )
            	    // InternalRDL.g:101:4: (lv_componentDefinitions_1_0= ruleComponentDefinition )
            	    {
            	    // InternalRDL.g:101:4: (lv_componentDefinitions_1_0= ruleComponentDefinition )
            	    // InternalRDL.g:102:5: lv_componentDefinitions_1_0= ruleComponentDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getComponentDefinitionsComponentDefinitionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_componentDefinitions_1_0=ruleComponentDefinition();

            	    state._fsp--;


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
            	    break;
            	case 3 :
            	    // InternalRDL.g:120:3: ( (lv_enumDefinitions_2_0= ruleEnumDefinition ) )
            	    {
            	    // InternalRDL.g:120:3: ( (lv_enumDefinitions_2_0= ruleEnumDefinition ) )
            	    // InternalRDL.g:121:4: (lv_enumDefinitions_2_0= ruleEnumDefinition )
            	    {
            	    // InternalRDL.g:121:4: (lv_enumDefinitions_2_0= ruleEnumDefinition )
            	    // InternalRDL.g:122:5: lv_enumDefinitions_2_0= ruleEnumDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getEnumDefinitionsEnumDefinitionParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_enumDefinitions_2_0=ruleEnumDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootRule());
            	    					}
            	    					add(
            	    						current,
            	    						"enumDefinitions",
            	    						lv_enumDefinitions_2_0,
            	    						"com.minres.rdl.RDL.EnumDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRDL.g:140:3: ( (lv_namedInstantiations_3_0= ruleNamedInstantiation ) )
            	    {
            	    // InternalRDL.g:140:3: ( (lv_namedInstantiations_3_0= ruleNamedInstantiation ) )
            	    // InternalRDL.g:141:4: (lv_namedInstantiations_3_0= ruleNamedInstantiation )
            	    {
            	    // InternalRDL.g:141:4: (lv_namedInstantiations_3_0= ruleNamedInstantiation )
            	    // InternalRDL.g:142:5: lv_namedInstantiations_3_0= ruleNamedInstantiation
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getNamedInstantiationsNamedInstantiationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_namedInstantiations_3_0=ruleNamedInstantiation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootRule());
            	    					}
            	    					add(
            	    						current,
            	    						"namedInstantiations",
            	    						lv_namedInstantiations_3_0,
            	    						"com.minres.rdl.RDL.NamedInstantiation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRDL.g:160:3: ( (lv_propertyAssignments_4_0= rulePropertyAssignment ) )
            	    {
            	    // InternalRDL.g:160:3: ( (lv_propertyAssignments_4_0= rulePropertyAssignment ) )
            	    // InternalRDL.g:161:4: (lv_propertyAssignments_4_0= rulePropertyAssignment )
            	    {
            	    // InternalRDL.g:161:4: (lv_propertyAssignments_4_0= rulePropertyAssignment )
            	    // InternalRDL.g:162:5: lv_propertyAssignments_4_0= rulePropertyAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getPropertyAssignmentsPropertyAssignmentParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_propertyAssignments_4_0=rulePropertyAssignment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootRule());
            	    					}
            	    					add(
            	    						current,
            	    						"propertyAssignments",
            	    						lv_propertyAssignments_4_0,
            	    						"com.minres.rdl.RDL.PropertyAssignment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRDL.g:180:3: ( (lv_propertyDefinitions_5_0= rulePropertyDefinition ) )
            	    {
            	    // InternalRDL.g:180:3: ( (lv_propertyDefinitions_5_0= rulePropertyDefinition ) )
            	    // InternalRDL.g:181:4: (lv_propertyDefinitions_5_0= rulePropertyDefinition )
            	    {
            	    // InternalRDL.g:181:4: (lv_propertyDefinitions_5_0= rulePropertyDefinition )
            	    // InternalRDL.g:182:5: lv_propertyDefinitions_5_0= rulePropertyDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getRootAccess().getPropertyDefinitionsPropertyDefinitionParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_propertyDefinitions_5_0=rulePropertyDefinition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootRule());
            	    					}
            	    					add(
            	    						current,
            	    						"propertyDefinitions",
            	    						lv_propertyDefinitions_5_0,
            	    						"com.minres.rdl.RDL.PropertyDefinition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

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
    // InternalRDL.g:203:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalRDL.g:203:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalRDL.g:204:2: iv_ruleInclude= ruleInclude EOF
            {
             newCompositeNode(grammarAccess.getIncludeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInclude=ruleInclude();

            state._fsp--;

             current =iv_ruleInclude; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:210:1: ruleInclude returns [EObject current=null] : (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;


        	enterRule();

        try {
            // InternalRDL.g:216:2: ( (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) ) )
            // InternalRDL.g:217:2: (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) )
            {
            // InternalRDL.g:217:2: (otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) ) )
            // InternalRDL.g:218:3: otherlv_0= '`include' ( (lv_importURI_1_0= RULE_STR ) )
            {
            otherlv_0=(Token)match(input,10,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getIncludeAccess().getIncludeKeyword_0());
            		
            // InternalRDL.g:222:3: ( (lv_importURI_1_0= RULE_STR ) )
            // InternalRDL.g:223:4: (lv_importURI_1_0= RULE_STR )
            {
            // InternalRDL.g:223:4: (lv_importURI_1_0= RULE_STR )
            // InternalRDL.g:224:5: lv_importURI_1_0= RULE_STR
            {
            lv_importURI_1_0=(Token)match(input,RULE_STR,FOLLOW_2); 

            					newLeafNode(lv_importURI_1_0, grammarAccess.getIncludeAccess().getImportURISTRTerminalRuleCall_1_0());
            				

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


            	leaveRule();

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
    // InternalRDL.g:244:1: entryRulePropertyDefinition returns [EObject current=null] : iv_rulePropertyDefinition= rulePropertyDefinition EOF ;
    public final EObject entryRulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDefinition = null;


        try {
            // InternalRDL.g:244:59: (iv_rulePropertyDefinition= rulePropertyDefinition EOF )
            // InternalRDL.g:245:2: iv_rulePropertyDefinition= rulePropertyDefinition EOF
            {
             newCompositeNode(grammarAccess.getPropertyDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyDefinition=rulePropertyDefinition();

            state._fsp--;

             current =iv_rulePropertyDefinition; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:251:1: rulePropertyDefinition returns [EObject current=null] : (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' ) ;
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
            // InternalRDL.g:257:2: ( (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' ) )
            // InternalRDL.g:258:2: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' )
            {
            // InternalRDL.g:258:2: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';' )
            // InternalRDL.g:259:3: otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) ) otherlv_33= '}' otherlv_34= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getPropertyDefinitionAccess().getPropertyKeyword_0());
            		
            // InternalRDL.g:263:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRDL.g:264:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRDL.g:264:4: (lv_name_1_0= RULE_ID )
            // InternalRDL.g:265:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPropertyDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

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

            otherlv_2=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getPropertyDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalRDL.g:285:3: ( (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) ) | ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) ) | ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt7=1;
                }
                break;
            case 20:
                {
                alt7=2;
                }
                break;
            case 17:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalRDL.g:286:4: (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) )
                    {
                    // InternalRDL.g:286:4: (otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) ) )
                    // InternalRDL.g:287:5: otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= rulePropertyTypeName ) ) otherlv_6= ';' ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_8); 

                    					newLeafNode(otherlv_3, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_0_0());
                    				
                    otherlv_4=(Token)match(input,14,FOLLOW_9); 

                    					newLeafNode(otherlv_4, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_0_1());
                    				
                    // InternalRDL.g:295:5: ( (lv_type_5_0= rulePropertyTypeName ) )
                    // InternalRDL.g:296:6: (lv_type_5_0= rulePropertyTypeName )
                    {
                    // InternalRDL.g:296:6: (lv_type_5_0= rulePropertyTypeName )
                    // InternalRDL.g:297:7: lv_type_5_0= rulePropertyTypeName
                    {

                    							newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_0_2_0());
                    						
                    pushFollow(FOLLOW_10);
                    lv_type_5_0=rulePropertyTypeName();

                    state._fsp--;


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

                    otherlv_6=(Token)match(input,15,FOLLOW_7); 

                    					newLeafNode(otherlv_6, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_0_3());
                    				
                    // InternalRDL.g:318:5: ( ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? ) | ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==20) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==17) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalRDL.g:319:6: ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? )
                            {
                            // InternalRDL.g:319:6: ( ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )? )
                            // InternalRDL.g:320:7: ( (lv_usage_7_0= rulePropertyUsage ) ) ( (lv_default_8_0= rulePropertyDefault ) )?
                            {
                            // InternalRDL.g:320:7: ( (lv_usage_7_0= rulePropertyUsage ) )
                            // InternalRDL.g:321:8: (lv_usage_7_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:321:8: (lv_usage_7_0= rulePropertyUsage )
                            // InternalRDL.g:322:9: lv_usage_7_0= rulePropertyUsage
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_0_4_0_0_0());
                            								
                            pushFollow(FOLLOW_11);
                            lv_usage_7_0=rulePropertyUsage();

                            state._fsp--;


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

                            // InternalRDL.g:339:7: ( (lv_default_8_0= rulePropertyDefault ) )?
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( (LA2_0==17) ) {
                                alt2=1;
                            }
                            switch (alt2) {
                                case 1 :
                                    // InternalRDL.g:340:8: (lv_default_8_0= rulePropertyDefault )
                                    {
                                    // InternalRDL.g:340:8: (lv_default_8_0= rulePropertyDefault )
                                    // InternalRDL.g:341:9: lv_default_8_0= rulePropertyDefault
                                    {

                                    									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_0_4_0_1_0());
                                    								
                                    pushFollow(FOLLOW_12);
                                    lv_default_8_0=rulePropertyDefault();

                                    state._fsp--;


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
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRDL.g:360:6: ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) )
                            {
                            // InternalRDL.g:360:6: ( ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) ) )
                            // InternalRDL.g:361:7: ( (lv_default_9_0= rulePropertyDefault ) ) ( (lv_usage_10_0= rulePropertyUsage ) )
                            {
                            // InternalRDL.g:361:7: ( (lv_default_9_0= rulePropertyDefault ) )
                            // InternalRDL.g:362:8: (lv_default_9_0= rulePropertyDefault )
                            {
                            // InternalRDL.g:362:8: (lv_default_9_0= rulePropertyDefault )
                            // InternalRDL.g:363:9: lv_default_9_0= rulePropertyDefault
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_0_4_1_0_0());
                            								
                            pushFollow(FOLLOW_13);
                            lv_default_9_0=rulePropertyDefault();

                            state._fsp--;


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

                            // InternalRDL.g:380:7: ( (lv_usage_10_0= rulePropertyUsage ) )
                            // InternalRDL.g:381:8: (lv_usage_10_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:381:8: (lv_usage_10_0= rulePropertyUsage )
                            // InternalRDL.g:382:9: lv_usage_10_0= rulePropertyUsage
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_0_4_1_1_0());
                            								
                            pushFollow(FOLLOW_12);
                            lv_usage_10_0=rulePropertyUsage();

                            state._fsp--;


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
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:403:4: ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) )
                    {
                    // InternalRDL.g:403:4: ( ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) ) )
                    // InternalRDL.g:404:5: ( (lv_usage_11_0= rulePropertyUsage ) ) ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) )
                    {
                    // InternalRDL.g:404:5: ( (lv_usage_11_0= rulePropertyUsage ) )
                    // InternalRDL.g:405:6: (lv_usage_11_0= rulePropertyUsage )
                    {
                    // InternalRDL.g:405:6: (lv_usage_11_0= rulePropertyUsage )
                    // InternalRDL.g:406:7: lv_usage_11_0= rulePropertyUsage
                    {

                    							newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_1_0_0());
                    						
                    pushFollow(FOLLOW_7);
                    lv_usage_11_0=rulePropertyUsage();

                    state._fsp--;


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

                    // InternalRDL.g:423:5: ( (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? ) | ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' ) )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==13) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==17) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalRDL.g:424:6: (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? )
                            {
                            // InternalRDL.g:424:6: (otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )? )
                            // InternalRDL.g:425:7: otherlv_12= 'type' otherlv_13= '=' ( (lv_type_14_0= rulePropertyTypeName ) ) otherlv_15= ';' ( (lv_default_16_0= rulePropertyDefault ) )?
                            {
                            otherlv_12=(Token)match(input,13,FOLLOW_8); 

                            							newLeafNode(otherlv_12, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_1_1_0_0());
                            						
                            otherlv_13=(Token)match(input,14,FOLLOW_9); 

                            							newLeafNode(otherlv_13, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_1_1_0_1());
                            						
                            // InternalRDL.g:433:7: ( (lv_type_14_0= rulePropertyTypeName ) )
                            // InternalRDL.g:434:8: (lv_type_14_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:434:8: (lv_type_14_0= rulePropertyTypeName )
                            // InternalRDL.g:435:9: lv_type_14_0= rulePropertyTypeName
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_1_1_0_2_0());
                            								
                            pushFollow(FOLLOW_10);
                            lv_type_14_0=rulePropertyTypeName();

                            state._fsp--;


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

                            otherlv_15=(Token)match(input,15,FOLLOW_11); 

                            							newLeafNode(otherlv_15, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_1_1_0_3());
                            						
                            // InternalRDL.g:456:7: ( (lv_default_16_0= rulePropertyDefault ) )?
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==17) ) {
                                alt4=1;
                            }
                            switch (alt4) {
                                case 1 :
                                    // InternalRDL.g:457:8: (lv_default_16_0= rulePropertyDefault )
                                    {
                                    // InternalRDL.g:457:8: (lv_default_16_0= rulePropertyDefault )
                                    // InternalRDL.g:458:9: lv_default_16_0= rulePropertyDefault
                                    {

                                    									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_1_1_0_4_0());
                                    								
                                    pushFollow(FOLLOW_12);
                                    lv_default_16_0=rulePropertyDefault();

                                    state._fsp--;


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
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRDL.g:477:6: ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' )
                            {
                            // InternalRDL.g:477:6: ( ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';' )
                            // InternalRDL.g:478:7: ( (lv_default_17_0= rulePropertyDefault ) ) otherlv_18= 'type' otherlv_19= '=' ( (lv_type_20_0= rulePropertyTypeName ) ) otherlv_21= ';'
                            {
                            // InternalRDL.g:478:7: ( (lv_default_17_0= rulePropertyDefault ) )
                            // InternalRDL.g:479:8: (lv_default_17_0= rulePropertyDefault )
                            {
                            // InternalRDL.g:479:8: (lv_default_17_0= rulePropertyDefault )
                            // InternalRDL.g:480:9: lv_default_17_0= rulePropertyDefault
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_1_1_1_0_0());
                            								
                            pushFollow(FOLLOW_14);
                            lv_default_17_0=rulePropertyDefault();

                            state._fsp--;


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

                            otherlv_18=(Token)match(input,13,FOLLOW_8); 

                            							newLeafNode(otherlv_18, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_1_1_1_1());
                            						
                            otherlv_19=(Token)match(input,14,FOLLOW_9); 

                            							newLeafNode(otherlv_19, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_1_1_1_2());
                            						
                            // InternalRDL.g:505:7: ( (lv_type_20_0= rulePropertyTypeName ) )
                            // InternalRDL.g:506:8: (lv_type_20_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:506:8: (lv_type_20_0= rulePropertyTypeName )
                            // InternalRDL.g:507:9: lv_type_20_0= rulePropertyTypeName
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_1_1_1_3_0());
                            								
                            pushFollow(FOLLOW_10);
                            lv_type_20_0=rulePropertyTypeName();

                            state._fsp--;


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

                            otherlv_21=(Token)match(input,15,FOLLOW_12); 

                            							newLeafNode(otherlv_21, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_1_1_1_4());
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:532:4: ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) )
                    {
                    // InternalRDL.g:532:4: ( ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) ) )
                    // InternalRDL.g:533:5: ( (lv_default_22_0= rulePropertyDefault ) ) ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) )
                    {
                    // InternalRDL.g:533:5: ( (lv_default_22_0= rulePropertyDefault ) )
                    // InternalRDL.g:534:6: (lv_default_22_0= rulePropertyDefault )
                    {
                    // InternalRDL.g:534:6: (lv_default_22_0= rulePropertyDefault )
                    // InternalRDL.g:535:7: lv_default_22_0= rulePropertyDefault
                    {

                    							newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultPropertyDefaultParserRuleCall_3_2_0_0());
                    						
                    pushFollow(FOLLOW_15);
                    lv_default_22_0=rulePropertyDefault();

                    state._fsp--;


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

                    // InternalRDL.g:552:5: ( (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) ) | ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==13) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==20) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalRDL.g:553:6: (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) )
                            {
                            // InternalRDL.g:553:6: (otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) ) )
                            // InternalRDL.g:554:7: otherlv_23= 'type' otherlv_24= '=' ( (lv_type_25_0= rulePropertyTypeName ) ) otherlv_26= ';' ( (lv_usage_27_0= rulePropertyUsage ) )
                            {
                            otherlv_23=(Token)match(input,13,FOLLOW_8); 

                            							newLeafNode(otherlv_23, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_2_1_0_0());
                            						
                            otherlv_24=(Token)match(input,14,FOLLOW_9); 

                            							newLeafNode(otherlv_24, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_2_1_0_1());
                            						
                            // InternalRDL.g:562:7: ( (lv_type_25_0= rulePropertyTypeName ) )
                            // InternalRDL.g:563:8: (lv_type_25_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:563:8: (lv_type_25_0= rulePropertyTypeName )
                            // InternalRDL.g:564:9: lv_type_25_0= rulePropertyTypeName
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_2_1_0_2_0());
                            								
                            pushFollow(FOLLOW_10);
                            lv_type_25_0=rulePropertyTypeName();

                            state._fsp--;


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

                            otherlv_26=(Token)match(input,15,FOLLOW_13); 

                            							newLeafNode(otherlv_26, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_2_1_0_3());
                            						
                            // InternalRDL.g:585:7: ( (lv_usage_27_0= rulePropertyUsage ) )
                            // InternalRDL.g:586:8: (lv_usage_27_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:586:8: (lv_usage_27_0= rulePropertyUsage )
                            // InternalRDL.g:587:9: lv_usage_27_0= rulePropertyUsage
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_2_1_0_4_0());
                            								
                            pushFollow(FOLLOW_12);
                            lv_usage_27_0=rulePropertyUsage();

                            state._fsp--;


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
                            break;
                        case 2 :
                            // InternalRDL.g:606:6: ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' )
                            {
                            // InternalRDL.g:606:6: ( ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';' )
                            // InternalRDL.g:607:7: ( (lv_usage_28_0= rulePropertyUsage ) ) otherlv_29= 'type' otherlv_30= '=' ( (lv_type_31_0= rulePropertyTypeName ) ) otherlv_32= ';'
                            {
                            // InternalRDL.g:607:7: ( (lv_usage_28_0= rulePropertyUsage ) )
                            // InternalRDL.g:608:8: (lv_usage_28_0= rulePropertyUsage )
                            {
                            // InternalRDL.g:608:8: (lv_usage_28_0= rulePropertyUsage )
                            // InternalRDL.g:609:9: lv_usage_28_0= rulePropertyUsage
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getUsagePropertyUsageParserRuleCall_3_2_1_1_0_0());
                            								
                            pushFollow(FOLLOW_14);
                            lv_usage_28_0=rulePropertyUsage();

                            state._fsp--;


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

                            otherlv_29=(Token)match(input,13,FOLLOW_8); 

                            							newLeafNode(otherlv_29, grammarAccess.getPropertyDefinitionAccess().getTypeKeyword_3_2_1_1_1());
                            						
                            otherlv_30=(Token)match(input,14,FOLLOW_9); 

                            							newLeafNode(otherlv_30, grammarAccess.getPropertyDefinitionAccess().getEqualsSignKeyword_3_2_1_1_2());
                            						
                            // InternalRDL.g:634:7: ( (lv_type_31_0= rulePropertyTypeName ) )
                            // InternalRDL.g:635:8: (lv_type_31_0= rulePropertyTypeName )
                            {
                            // InternalRDL.g:635:8: (lv_type_31_0= rulePropertyTypeName )
                            // InternalRDL.g:636:9: lv_type_31_0= rulePropertyTypeName
                            {

                            									newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeNameEnumRuleCall_3_2_1_1_3_0());
                            								
                            pushFollow(FOLLOW_10);
                            lv_type_31_0=rulePropertyTypeName();

                            state._fsp--;


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

                            otherlv_32=(Token)match(input,15,FOLLOW_12); 

                            							newLeafNode(otherlv_32, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_3_2_1_1_4());
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_33=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_33, grammarAccess.getPropertyDefinitionAccess().getRightCurlyBracketKeyword_4());
            		
            otherlv_34=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_34, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:673:1: entryRulePropertyDefault returns [EObject current=null] : iv_rulePropertyDefault= rulePropertyDefault EOF ;
    public final EObject entryRulePropertyDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDefault = null;


        try {
            // InternalRDL.g:673:56: (iv_rulePropertyDefault= rulePropertyDefault EOF )
            // InternalRDL.g:674:2: iv_rulePropertyDefault= rulePropertyDefault EOF
            {
             newCompositeNode(grammarAccess.getPropertyDefaultRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyDefault=rulePropertyDefault();

            state._fsp--;

             current =iv_rulePropertyDefault; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:680:1: rulePropertyDefault returns [EObject current=null] : (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' ) ;
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
            // InternalRDL.g:686:2: ( (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' ) )
            // InternalRDL.g:687:2: (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' )
            {
            // InternalRDL.g:687:2: (otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';' )
            // InternalRDL.g:688:3: otherlv_0= 'default' otherlv_1= '=' ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getPropertyDefaultAccess().getDefaultKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyDefaultAccess().getEqualsSignKeyword_1());
            		
            // InternalRDL.g:696:3: ( ( (lv_string_2_0= RULE_STR ) ) | ( (lv_value_3_0= RULE_NUM ) ) | ( (lv_string_4_0= 'true' ) ) | ( (lv_string_5_0= 'false' ) ) )
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
            case 18:
                {
                alt8=3;
                }
                break;
            case 19:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalRDL.g:697:4: ( (lv_string_2_0= RULE_STR ) )
                    {
                    // InternalRDL.g:697:4: ( (lv_string_2_0= RULE_STR ) )
                    // InternalRDL.g:698:5: (lv_string_2_0= RULE_STR )
                    {
                    // InternalRDL.g:698:5: (lv_string_2_0= RULE_STR )
                    // InternalRDL.g:699:6: lv_string_2_0= RULE_STR
                    {
                    lv_string_2_0=(Token)match(input,RULE_STR,FOLLOW_10); 

                    						newLeafNode(lv_string_2_0, grammarAccess.getPropertyDefaultAccess().getStringSTRTerminalRuleCall_2_0_0());
                    					

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
                    break;
                case 2 :
                    // InternalRDL.g:716:4: ( (lv_value_3_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:716:4: ( (lv_value_3_0= RULE_NUM ) )
                    // InternalRDL.g:717:5: (lv_value_3_0= RULE_NUM )
                    {
                    // InternalRDL.g:717:5: (lv_value_3_0= RULE_NUM )
                    // InternalRDL.g:718:6: lv_value_3_0= RULE_NUM
                    {
                    lv_value_3_0=(Token)match(input,RULE_NUM,FOLLOW_10); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getPropertyDefaultAccess().getValueNUMTerminalRuleCall_2_1_0());
                    					

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
                    break;
                case 3 :
                    // InternalRDL.g:735:4: ( (lv_string_4_0= 'true' ) )
                    {
                    // InternalRDL.g:735:4: ( (lv_string_4_0= 'true' ) )
                    // InternalRDL.g:736:5: (lv_string_4_0= 'true' )
                    {
                    // InternalRDL.g:736:5: (lv_string_4_0= 'true' )
                    // InternalRDL.g:737:6: lv_string_4_0= 'true'
                    {
                    lv_string_4_0=(Token)match(input,18,FOLLOW_10); 

                    						newLeafNode(lv_string_4_0, grammarAccess.getPropertyDefaultAccess().getStringTrueKeyword_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyDefaultRule());
                    						}
                    						setWithLastConsumed(current, "string", lv_string_4_0, "true");
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:750:4: ( (lv_string_5_0= 'false' ) )
                    {
                    // InternalRDL.g:750:4: ( (lv_string_5_0= 'false' ) )
                    // InternalRDL.g:751:5: (lv_string_5_0= 'false' )
                    {
                    // InternalRDL.g:751:5: (lv_string_5_0= 'false' )
                    // InternalRDL.g:752:6: lv_string_5_0= 'false'
                    {
                    lv_string_5_0=(Token)match(input,19,FOLLOW_10); 

                    						newLeafNode(lv_string_5_0, grammarAccess.getPropertyDefaultAccess().getStringFalseKeyword_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyDefaultRule());
                    						}
                    						setWithLastConsumed(current, "string", lv_string_5_0, "false");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getPropertyDefaultAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:773:1: entryRulePropertyUsage returns [EObject current=null] : iv_rulePropertyUsage= rulePropertyUsage EOF ;
    public final EObject entryRulePropertyUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyUsage = null;


        try {
            // InternalRDL.g:773:54: (iv_rulePropertyUsage= rulePropertyUsage EOF )
            // InternalRDL.g:774:2: iv_rulePropertyUsage= rulePropertyUsage EOF
            {
             newCompositeNode(grammarAccess.getPropertyUsageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyUsage=rulePropertyUsage();

            state._fsp--;

             current =iv_rulePropertyUsage; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:780:1: rulePropertyUsage returns [EObject current=null] : (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' ) ;
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
            // InternalRDL.g:786:2: ( (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' ) )
            // InternalRDL.g:787:2: (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' )
            {
            // InternalRDL.g:787:2: (otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';' )
            // InternalRDL.g:788:3: otherlv_0= 'component' otherlv_1= '=' ( (lv_components_2_0= rulePropertyComponent ) ) (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getPropertyUsageAccess().getComponentKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyUsageAccess().getEqualsSignKeyword_1());
            		
            // InternalRDL.g:796:3: ( (lv_components_2_0= rulePropertyComponent ) )
            // InternalRDL.g:797:4: (lv_components_2_0= rulePropertyComponent )
            {
            // InternalRDL.g:797:4: (lv_components_2_0= rulePropertyComponent )
            // InternalRDL.g:798:5: lv_components_2_0= rulePropertyComponent
            {

            					newCompositeNode(grammarAccess.getPropertyUsageAccess().getComponentsPropertyComponentEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_18);
            lv_components_2_0=rulePropertyComponent();

            state._fsp--;


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

            // InternalRDL.g:815:3: (otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalRDL.g:816:4: otherlv_3= '|' ( (lv_components_4_0= rulePropertyComponent ) )
            	    {
            	    otherlv_3=(Token)match(input,21,FOLLOW_17); 

            	    				newLeafNode(otherlv_3, grammarAccess.getPropertyUsageAccess().getVerticalLineKeyword_3_0());
            	    			
            	    // InternalRDL.g:820:4: ( (lv_components_4_0= rulePropertyComponent ) )
            	    // InternalRDL.g:821:5: (lv_components_4_0= rulePropertyComponent )
            	    {
            	    // InternalRDL.g:821:5: (lv_components_4_0= rulePropertyComponent )
            	    // InternalRDL.g:822:6: lv_components_4_0= rulePropertyComponent
            	    {

            	    						newCompositeNode(grammarAccess.getPropertyUsageAccess().getComponentsPropertyComponentEnumRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_18);
            	    lv_components_4_0=rulePropertyComponent();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getPropertyUsageAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:848:1: entryRuleComponentDefinition returns [EObject current=null] : iv_ruleComponentDefinition= ruleComponentDefinition EOF ;
    public final EObject entryRuleComponentDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentDefinition = null;


        try {
            // InternalRDL.g:848:60: (iv_ruleComponentDefinition= ruleComponentDefinition EOF )
            // InternalRDL.g:849:2: iv_ruleComponentDefinition= ruleComponentDefinition EOF
            {
             newCompositeNode(grammarAccess.getComponentDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentDefinition=ruleComponentDefinition();

            state._fsp--;

             current =iv_ruleComponentDefinition; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:855:1: ruleComponentDefinition returns [EObject current=null] : ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) | ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) ) | ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) ) )* otherlv_7= '}' ( (lv_immediateInstantiation_8_0= ruleImmediateInstantiation ) )? otherlv_9= ';' ) ;
    public final EObject ruleComponentDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_componentDefinitions_3_0 = null;

        EObject lv_namedInstantiations_4_0 = null;

        EObject lv_propertyAssignments_5_0 = null;

        EObject lv_enumDefinitions_6_0 = null;

        EObject lv_immediateInstantiation_8_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:861:2: ( ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) | ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) ) | ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) ) )* otherlv_7= '}' ( (lv_immediateInstantiation_8_0= ruleImmediateInstantiation ) )? otherlv_9= ';' ) )
            // InternalRDL.g:862:2: ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) | ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) ) | ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) ) )* otherlv_7= '}' ( (lv_immediateInstantiation_8_0= ruleImmediateInstantiation ) )? otherlv_9= ';' )
            {
            // InternalRDL.g:862:2: ( ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) | ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) ) | ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) ) )* otherlv_7= '}' ( (lv_immediateInstantiation_8_0= ruleImmediateInstantiation ) )? otherlv_9= ';' )
            // InternalRDL.g:863:3: ( (lv_type_0_0= ruleComponentDefinitionType ) ) ( (lv_name_1_0= RULE_ID ) )? otherlv_2= '{' ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) | ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) ) | ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) ) )* otherlv_7= '}' ( (lv_immediateInstantiation_8_0= ruleImmediateInstantiation ) )? otherlv_9= ';'
            {
            // InternalRDL.g:863:3: ( (lv_type_0_0= ruleComponentDefinitionType ) )
            // InternalRDL.g:864:4: (lv_type_0_0= ruleComponentDefinitionType )
            {
            // InternalRDL.g:864:4: (lv_type_0_0= ruleComponentDefinitionType )
            // InternalRDL.g:865:5: lv_type_0_0= ruleComponentDefinitionType
            {

            					newCompositeNode(grammarAccess.getComponentDefinitionAccess().getTypeComponentDefinitionTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_19);
            lv_type_0_0=ruleComponentDefinitionType();

            state._fsp--;


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

            // InternalRDL.g:882:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRDL.g:883:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalRDL.g:883:4: (lv_name_1_0= RULE_ID )
                    // InternalRDL.g:884:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

                    					newLeafNode(lv_name_1_0, grammarAccess.getComponentDefinitionAccess().getNameIDTerminalRuleCall_1_0());
                    				

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
                    break;

            }

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getComponentDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalRDL.g:904:3: ( ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) ) | ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) ) | ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) ) )*
            loop11:
            do {
                int alt11=5;
                switch ( input.LA(1) ) {
                case 40:
                case 41:
                case 42:
                case 43:
                case 45:
                    {
                    alt11=1;
                    }
                    break;
                case 22:
                case 24:
                    {
                    alt11=2;
                    }
                    break;
                case 23:
                    {
                    int LA11_4 = input.LA(2);

                    if ( (LA11_4==RULE_ID||LA11_4==24) ) {
                        alt11=2;
                    }
                    else if ( ((LA11_4>=14 && LA11_4<=15)) ) {
                        alt11=3;
                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA11_5 = input.LA(2);

                    if ( ((LA11_5>=14 && LA11_5<=15)||(LA11_5>=32 && LA11_5<=33)) ) {
                        alt11=3;
                    }
                    else if ( (LA11_5==RULE_ID) ) {
                        alt11=2;
                    }


                    }
                    break;
                case 17:
                case 35:
                case 36:
                case 47:
                case 48:
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
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                    {
                    alt11=3;
                    }
                    break;
                case 34:
                    {
                    alt11=4;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // InternalRDL.g:905:4: ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) )
            	    {
            	    // InternalRDL.g:905:4: ( (lv_componentDefinitions_3_0= ruleComponentDefinition ) )
            	    // InternalRDL.g:906:5: (lv_componentDefinitions_3_0= ruleComponentDefinition )
            	    {
            	    // InternalRDL.g:906:5: (lv_componentDefinitions_3_0= ruleComponentDefinition )
            	    // InternalRDL.g:907:6: lv_componentDefinitions_3_0= ruleComponentDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getComponentDefinitionAccess().getComponentDefinitionsComponentDefinitionParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_componentDefinitions_3_0=ruleComponentDefinition();

            	    state._fsp--;


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
            	    break;
            	case 2 :
            	    // InternalRDL.g:925:4: ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) )
            	    {
            	    // InternalRDL.g:925:4: ( (lv_namedInstantiations_4_0= ruleNamedInstantiation ) )
            	    // InternalRDL.g:926:5: (lv_namedInstantiations_4_0= ruleNamedInstantiation )
            	    {
            	    // InternalRDL.g:926:5: (lv_namedInstantiations_4_0= ruleNamedInstantiation )
            	    // InternalRDL.g:927:6: lv_namedInstantiations_4_0= ruleNamedInstantiation
            	    {

            	    						newCompositeNode(grammarAccess.getComponentDefinitionAccess().getNamedInstantiationsNamedInstantiationParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_namedInstantiations_4_0=ruleNamedInstantiation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"namedInstantiations",
            	    							lv_namedInstantiations_4_0,
            	    							"com.minres.rdl.RDL.NamedInstantiation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRDL.g:945:4: ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) )
            	    {
            	    // InternalRDL.g:945:4: ( (lv_propertyAssignments_5_0= rulePropertyAssignment ) )
            	    // InternalRDL.g:946:5: (lv_propertyAssignments_5_0= rulePropertyAssignment )
            	    {
            	    // InternalRDL.g:946:5: (lv_propertyAssignments_5_0= rulePropertyAssignment )
            	    // InternalRDL.g:947:6: lv_propertyAssignments_5_0= rulePropertyAssignment
            	    {

            	    						newCompositeNode(grammarAccess.getComponentDefinitionAccess().getPropertyAssignmentsPropertyAssignmentParserRuleCall_3_2_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_propertyAssignments_5_0=rulePropertyAssignment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"propertyAssignments",
            	    							lv_propertyAssignments_5_0,
            	    							"com.minres.rdl.RDL.PropertyAssignment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRDL.g:965:4: ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) )
            	    {
            	    // InternalRDL.g:965:4: ( (lv_enumDefinitions_6_0= ruleEnumDefinition ) )
            	    // InternalRDL.g:966:5: (lv_enumDefinitions_6_0= ruleEnumDefinition )
            	    {
            	    // InternalRDL.g:966:5: (lv_enumDefinitions_6_0= ruleEnumDefinition )
            	    // InternalRDL.g:967:6: lv_enumDefinitions_6_0= ruleEnumDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getComponentDefinitionAccess().getEnumDefinitionsEnumDefinitionParserRuleCall_3_3_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_enumDefinitions_6_0=ruleEnumDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"enumDefinitions",
            	    							lv_enumDefinitions_6_0,
            	    							"com.minres.rdl.RDL.EnumDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_7=(Token)match(input,16,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getComponentDefinitionAccess().getRightCurlyBracketKeyword_4());
            		
            // InternalRDL.g:989:3: ( (lv_immediateInstantiation_8_0= ruleImmediateInstantiation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRDL.g:990:4: (lv_immediateInstantiation_8_0= ruleImmediateInstantiation )
                    {
                    // InternalRDL.g:990:4: (lv_immediateInstantiation_8_0= ruleImmediateInstantiation )
                    // InternalRDL.g:991:5: lv_immediateInstantiation_8_0= ruleImmediateInstantiation
                    {

                    					newCompositeNode(grammarAccess.getComponentDefinitionAccess().getImmediateInstantiationImmediateInstantiationParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_immediateInstantiation_8_0=ruleImmediateInstantiation();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getComponentDefinitionRule());
                    					}
                    					set(
                    						current,
                    						"immediateInstantiation",
                    						lv_immediateInstantiation_8_0,
                    						"com.minres.rdl.RDL.ImmediateInstantiation");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getComponentDefinitionAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleNamedInstantiation"
    // InternalRDL.g:1016:1: entryRuleNamedInstantiation returns [EObject current=null] : iv_ruleNamedInstantiation= ruleNamedInstantiation EOF ;
    public final EObject entryRuleNamedInstantiation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedInstantiation = null;


        try {
            // InternalRDL.g:1016:59: (iv_ruleNamedInstantiation= ruleNamedInstantiation EOF )
            // InternalRDL.g:1017:2: iv_ruleNamedInstantiation= ruleNamedInstantiation EOF
            {
             newCompositeNode(grammarAccess.getNamedInstantiationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamedInstantiation=ruleNamedInstantiation();

            state._fsp--;

             current =iv_ruleNamedInstantiation; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNamedInstantiation"


    // $ANTLR start "ruleNamedInstantiation"
    // InternalRDL.g:1023:1: ruleNamedInstantiation returns [EObject current=null] : ( ( (lv_external_0_0= 'external' ) )? ( (lv_internal_1_0= 'internal' ) )? (otherlv_2= 'alias' ( (lv_alias_3_0= RULE_ID ) ) )? ( (otherlv_4= RULE_ID ) ) ( (lv_componentInstances_5_0= ruleComponentInstance ) ) (otherlv_6= ',' ( (lv_componentInstances_7_0= ruleComponentInstance ) ) )* otherlv_8= ';' ) ;
    public final EObject ruleNamedInstantiation() throws RecognitionException {
        EObject current = null;

        Token lv_external_0_0=null;
        Token lv_internal_1_0=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_componentInstances_5_0 = null;

        EObject lv_componentInstances_7_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1029:2: ( ( ( (lv_external_0_0= 'external' ) )? ( (lv_internal_1_0= 'internal' ) )? (otherlv_2= 'alias' ( (lv_alias_3_0= RULE_ID ) ) )? ( (otherlv_4= RULE_ID ) ) ( (lv_componentInstances_5_0= ruleComponentInstance ) ) (otherlv_6= ',' ( (lv_componentInstances_7_0= ruleComponentInstance ) ) )* otherlv_8= ';' ) )
            // InternalRDL.g:1030:2: ( ( (lv_external_0_0= 'external' ) )? ( (lv_internal_1_0= 'internal' ) )? (otherlv_2= 'alias' ( (lv_alias_3_0= RULE_ID ) ) )? ( (otherlv_4= RULE_ID ) ) ( (lv_componentInstances_5_0= ruleComponentInstance ) ) (otherlv_6= ',' ( (lv_componentInstances_7_0= ruleComponentInstance ) ) )* otherlv_8= ';' )
            {
            // InternalRDL.g:1030:2: ( ( (lv_external_0_0= 'external' ) )? ( (lv_internal_1_0= 'internal' ) )? (otherlv_2= 'alias' ( (lv_alias_3_0= RULE_ID ) ) )? ( (otherlv_4= RULE_ID ) ) ( (lv_componentInstances_5_0= ruleComponentInstance ) ) (otherlv_6= ',' ( (lv_componentInstances_7_0= ruleComponentInstance ) ) )* otherlv_8= ';' )
            // InternalRDL.g:1031:3: ( (lv_external_0_0= 'external' ) )? ( (lv_internal_1_0= 'internal' ) )? (otherlv_2= 'alias' ( (lv_alias_3_0= RULE_ID ) ) )? ( (otherlv_4= RULE_ID ) ) ( (lv_componentInstances_5_0= ruleComponentInstance ) ) (otherlv_6= ',' ( (lv_componentInstances_7_0= ruleComponentInstance ) ) )* otherlv_8= ';'
            {
            // InternalRDL.g:1031:3: ( (lv_external_0_0= 'external' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRDL.g:1032:4: (lv_external_0_0= 'external' )
                    {
                    // InternalRDL.g:1032:4: (lv_external_0_0= 'external' )
                    // InternalRDL.g:1033:5: lv_external_0_0= 'external'
                    {
                    lv_external_0_0=(Token)match(input,22,FOLLOW_22); 

                    					newLeafNode(lv_external_0_0, grammarAccess.getNamedInstantiationAccess().getExternalExternalKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNamedInstantiationRule());
                    					}
                    					setWithLastConsumed(current, "external", true, "external");
                    				

                    }


                    }
                    break;

            }

            // InternalRDL.g:1045:3: ( (lv_internal_1_0= 'internal' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRDL.g:1046:4: (lv_internal_1_0= 'internal' )
                    {
                    // InternalRDL.g:1046:4: (lv_internal_1_0= 'internal' )
                    // InternalRDL.g:1047:5: lv_internal_1_0= 'internal'
                    {
                    lv_internal_1_0=(Token)match(input,23,FOLLOW_23); 

                    					newLeafNode(lv_internal_1_0, grammarAccess.getNamedInstantiationAccess().getInternalInternalKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNamedInstantiationRule());
                    					}
                    					setWithLastConsumed(current, "internal", true, "internal");
                    				

                    }


                    }
                    break;

            }

            // InternalRDL.g:1059:3: (otherlv_2= 'alias' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRDL.g:1060:4: otherlv_2= 'alias' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getNamedInstantiationAccess().getAliasKeyword_2_0());
                    			
                    // InternalRDL.g:1064:4: ( (lv_alias_3_0= RULE_ID ) )
                    // InternalRDL.g:1065:5: (lv_alias_3_0= RULE_ID )
                    {
                    // InternalRDL.g:1065:5: (lv_alias_3_0= RULE_ID )
                    // InternalRDL.g:1066:6: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)match(input,RULE_ID,FOLLOW_5); 

                    						newLeafNode(lv_alias_3_0, grammarAccess.getNamedInstantiationAccess().getAliasIDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNamedInstantiationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"alias",
                    							lv_alias_3_0,
                    							"com.minres.rdl.RDL.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRDL.g:1083:3: ( (otherlv_4= RULE_ID ) )
            // InternalRDL.g:1084:4: (otherlv_4= RULE_ID )
            {
            // InternalRDL.g:1084:4: (otherlv_4= RULE_ID )
            // InternalRDL.g:1085:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNamedInstantiationRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_4, grammarAccess.getNamedInstantiationAccess().getComponentComponentDefinitionCrossReference_3_0());
            				

            }


            }

            // InternalRDL.g:1096:3: ( (lv_componentInstances_5_0= ruleComponentInstance ) )
            // InternalRDL.g:1097:4: (lv_componentInstances_5_0= ruleComponentInstance )
            {
            // InternalRDL.g:1097:4: (lv_componentInstances_5_0= ruleComponentInstance )
            // InternalRDL.g:1098:5: lv_componentInstances_5_0= ruleComponentInstance
            {

            					newCompositeNode(grammarAccess.getNamedInstantiationAccess().getComponentInstancesComponentInstanceParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_25);
            lv_componentInstances_5_0=ruleComponentInstance();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNamedInstantiationRule());
            					}
            					add(
            						current,
            						"componentInstances",
            						lv_componentInstances_5_0,
            						"com.minres.rdl.RDL.ComponentInstance");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRDL.g:1115:3: (otherlv_6= ',' ( (lv_componentInstances_7_0= ruleComponentInstance ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalRDL.g:1116:4: otherlv_6= ',' ( (lv_componentInstances_7_0= ruleComponentInstance ) )
            	    {
            	    otherlv_6=(Token)match(input,25,FOLLOW_24); 

            	    				newLeafNode(otherlv_6, grammarAccess.getNamedInstantiationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalRDL.g:1120:4: ( (lv_componentInstances_7_0= ruleComponentInstance ) )
            	    // InternalRDL.g:1121:5: (lv_componentInstances_7_0= ruleComponentInstance )
            	    {
            	    // InternalRDL.g:1121:5: (lv_componentInstances_7_0= ruleComponentInstance )
            	    // InternalRDL.g:1122:6: lv_componentInstances_7_0= ruleComponentInstance
            	    {

            	    						newCompositeNode(grammarAccess.getNamedInstantiationAccess().getComponentInstancesComponentInstanceParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_componentInstances_7_0=ruleComponentInstance();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNamedInstantiationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"componentInstances",
            	    							lv_componentInstances_7_0,
            	    							"com.minres.rdl.RDL.ComponentInstance");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_8=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getNamedInstantiationAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedInstantiation"


    // $ANTLR start "entryRuleImmediateInstantiation"
    // InternalRDL.g:1148:1: entryRuleImmediateInstantiation returns [EObject current=null] : iv_ruleImmediateInstantiation= ruleImmediateInstantiation EOF ;
    public final EObject entryRuleImmediateInstantiation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImmediateInstantiation = null;


        try {
            // InternalRDL.g:1148:63: (iv_ruleImmediateInstantiation= ruleImmediateInstantiation EOF )
            // InternalRDL.g:1149:2: iv_ruleImmediateInstantiation= ruleImmediateInstantiation EOF
            {
             newCompositeNode(grammarAccess.getImmediateInstantiationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImmediateInstantiation=ruleImmediateInstantiation();

            state._fsp--;

             current =iv_ruleImmediateInstantiation; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleImmediateInstantiation"


    // $ANTLR start "ruleImmediateInstantiation"
    // InternalRDL.g:1155:1: ruleImmediateInstantiation returns [EObject current=null] : ( ( (lv_external_0_0= 'external' ) )? ( (lv_componentInstances_1_0= ruleComponentInstance ) ) (otherlv_2= ',' ( (lv_componentInstances_3_0= ruleComponentInstance ) ) )* ) ;
    public final EObject ruleImmediateInstantiation() throws RecognitionException {
        EObject current = null;

        Token lv_external_0_0=null;
        Token otherlv_2=null;
        EObject lv_componentInstances_1_0 = null;

        EObject lv_componentInstances_3_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1161:2: ( ( ( (lv_external_0_0= 'external' ) )? ( (lv_componentInstances_1_0= ruleComponentInstance ) ) (otherlv_2= ',' ( (lv_componentInstances_3_0= ruleComponentInstance ) ) )* ) )
            // InternalRDL.g:1162:2: ( ( (lv_external_0_0= 'external' ) )? ( (lv_componentInstances_1_0= ruleComponentInstance ) ) (otherlv_2= ',' ( (lv_componentInstances_3_0= ruleComponentInstance ) ) )* )
            {
            // InternalRDL.g:1162:2: ( ( (lv_external_0_0= 'external' ) )? ( (lv_componentInstances_1_0= ruleComponentInstance ) ) (otherlv_2= ',' ( (lv_componentInstances_3_0= ruleComponentInstance ) ) )* )
            // InternalRDL.g:1163:3: ( (lv_external_0_0= 'external' ) )? ( (lv_componentInstances_1_0= ruleComponentInstance ) ) (otherlv_2= ',' ( (lv_componentInstances_3_0= ruleComponentInstance ) ) )*
            {
            // InternalRDL.g:1163:3: ( (lv_external_0_0= 'external' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==22) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRDL.g:1164:4: (lv_external_0_0= 'external' )
                    {
                    // InternalRDL.g:1164:4: (lv_external_0_0= 'external' )
                    // InternalRDL.g:1165:5: lv_external_0_0= 'external'
                    {
                    lv_external_0_0=(Token)match(input,22,FOLLOW_24); 

                    					newLeafNode(lv_external_0_0, grammarAccess.getImmediateInstantiationAccess().getExternalExternalKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getImmediateInstantiationRule());
                    					}
                    					setWithLastConsumed(current, "external", true, "external");
                    				

                    }


                    }
                    break;

            }

            // InternalRDL.g:1177:3: ( (lv_componentInstances_1_0= ruleComponentInstance ) )
            // InternalRDL.g:1178:4: (lv_componentInstances_1_0= ruleComponentInstance )
            {
            // InternalRDL.g:1178:4: (lv_componentInstances_1_0= ruleComponentInstance )
            // InternalRDL.g:1179:5: lv_componentInstances_1_0= ruleComponentInstance
            {

            					newCompositeNode(grammarAccess.getImmediateInstantiationAccess().getComponentInstancesComponentInstanceParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_26);
            lv_componentInstances_1_0=ruleComponentInstance();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImmediateInstantiationRule());
            					}
            					add(
            						current,
            						"componentInstances",
            						lv_componentInstances_1_0,
            						"com.minres.rdl.RDL.ComponentInstance");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRDL.g:1196:3: (otherlv_2= ',' ( (lv_componentInstances_3_0= ruleComponentInstance ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==25) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalRDL.g:1197:4: otherlv_2= ',' ( (lv_componentInstances_3_0= ruleComponentInstance ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_24); 

            	    				newLeafNode(otherlv_2, grammarAccess.getImmediateInstantiationAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRDL.g:1201:4: ( (lv_componentInstances_3_0= ruleComponentInstance ) )
            	    // InternalRDL.g:1202:5: (lv_componentInstances_3_0= ruleComponentInstance )
            	    {
            	    // InternalRDL.g:1202:5: (lv_componentInstances_3_0= ruleComponentInstance )
            	    // InternalRDL.g:1203:6: lv_componentInstances_3_0= ruleComponentInstance
            	    {

            	    						newCompositeNode(grammarAccess.getImmediateInstantiationAccess().getComponentInstancesComponentInstanceParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_componentInstances_3_0=ruleComponentInstance();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getImmediateInstantiationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"componentInstances",
            	    							lv_componentInstances_3_0,
            	    							"com.minres.rdl.RDL.ComponentInstance");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImmediateInstantiation"


    // $ANTLR start "entryRuleComponentInstance"
    // InternalRDL.g:1225:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // InternalRDL.g:1225:58: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // InternalRDL.g:1226:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1232:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? ) ;
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
            // InternalRDL.g:1238:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? ) )
            // InternalRDL.g:1239:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? )
            {
            // InternalRDL.g:1239:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )? )
            // InternalRDL.g:1240:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_range_1_0= ruleRange ) )? (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )? (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )? (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )? (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )?
            {
            // InternalRDL.g:1240:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRDL.g:1241:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRDL.g:1241:4: (lv_name_0_0= RULE_ID )
            // InternalRDL.g:1242:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_0_0, grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_0_0());
            				

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

            // InternalRDL.g:1258:3: ( (lv_range_1_0= ruleRange ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRDL.g:1259:4: (lv_range_1_0= ruleRange )
                    {
                    // InternalRDL.g:1259:4: (lv_range_1_0= ruleRange )
                    // InternalRDL.g:1260:5: lv_range_1_0= ruleRange
                    {

                    					newCompositeNode(grammarAccess.getComponentInstanceAccess().getRangeRangeParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_28);
                    lv_range_1_0=ruleRange();

                    state._fsp--;


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
                    break;

            }

            // InternalRDL.g:1277:3: (otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==14) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRDL.g:1278:4: otherlv_2= '=' ( (lv_reset_3_0= RULE_NUM ) )
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_29); 

                    				newLeafNode(otherlv_2, grammarAccess.getComponentInstanceAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalRDL.g:1282:4: ( (lv_reset_3_0= RULE_NUM ) )
                    // InternalRDL.g:1283:5: (lv_reset_3_0= RULE_NUM )
                    {
                    // InternalRDL.g:1283:5: (lv_reset_3_0= RULE_NUM )
                    // InternalRDL.g:1284:6: lv_reset_3_0= RULE_NUM
                    {
                    lv_reset_3_0=(Token)match(input,RULE_NUM,FOLLOW_30); 

                    						newLeafNode(lv_reset_3_0, grammarAccess.getComponentInstanceAccess().getResetNUMTerminalRuleCall_2_1_0());
                    					

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
                    break;

            }

            // InternalRDL.g:1301:3: (otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRDL.g:1302:4: otherlv_4= '@' ( (lv_address_5_0= RULE_NUM ) )
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_29); 

                    				newLeafNode(otherlv_4, grammarAccess.getComponentInstanceAccess().getCommercialAtKeyword_3_0());
                    			
                    // InternalRDL.g:1306:4: ( (lv_address_5_0= RULE_NUM ) )
                    // InternalRDL.g:1307:5: (lv_address_5_0= RULE_NUM )
                    {
                    // InternalRDL.g:1307:5: (lv_address_5_0= RULE_NUM )
                    // InternalRDL.g:1308:6: lv_address_5_0= RULE_NUM
                    {
                    lv_address_5_0=(Token)match(input,RULE_NUM,FOLLOW_31); 

                    						newLeafNode(lv_address_5_0, grammarAccess.getComponentInstanceAccess().getAddressNUMTerminalRuleCall_3_1_0());
                    					

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
                    break;

            }

            // InternalRDL.g:1325:3: (otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRDL.g:1326:4: otherlv_6= '+=' ( (lv_addrInc_7_0= RULE_NUM ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_29); 

                    				newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getPlusSignEqualsSignKeyword_4_0());
                    			
                    // InternalRDL.g:1330:4: ( (lv_addrInc_7_0= RULE_NUM ) )
                    // InternalRDL.g:1331:5: (lv_addrInc_7_0= RULE_NUM )
                    {
                    // InternalRDL.g:1331:5: (lv_addrInc_7_0= RULE_NUM )
                    // InternalRDL.g:1332:6: lv_addrInc_7_0= RULE_NUM
                    {
                    lv_addrInc_7_0=(Token)match(input,RULE_NUM,FOLLOW_32); 

                    						newLeafNode(lv_addrInc_7_0, grammarAccess.getComponentInstanceAccess().getAddrIncNUMTerminalRuleCall_4_1_0());
                    					

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
                    break;

            }

            // InternalRDL.g:1349:3: (otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRDL.g:1350:4: otherlv_8= '%=' ( (lv_addrMod_9_0= RULE_NUM ) )
                    {
                    otherlv_8=(Token)match(input,28,FOLLOW_29); 

                    				newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getPercentSignEqualsSignKeyword_5_0());
                    			
                    // InternalRDL.g:1354:4: ( (lv_addrMod_9_0= RULE_NUM ) )
                    // InternalRDL.g:1355:5: (lv_addrMod_9_0= RULE_NUM )
                    {
                    // InternalRDL.g:1355:5: (lv_addrMod_9_0= RULE_NUM )
                    // InternalRDL.g:1356:6: lv_addrMod_9_0= RULE_NUM
                    {
                    lv_addrMod_9_0=(Token)match(input,RULE_NUM,FOLLOW_2); 

                    						newLeafNode(lv_addrMod_9_0, grammarAccess.getComponentInstanceAccess().getAddrModNUMTerminalRuleCall_5_1_0());
                    					

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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRDL.g:1377:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalRDL.g:1377:46: (iv_ruleRange= ruleRange EOF )
            // InternalRDL.g:1378:2: iv_ruleRange= ruleRange EOF
            {
             newCompositeNode(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;

             current =iv_ruleRange; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1384:1: ruleRange returns [EObject current=null] : (otherlv_0= '[' ( ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_start_1_0=null;
        Token otherlv_2=null;
        Token lv_end_3_0=null;
        Token lv_size_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRDL.g:1390:2: ( (otherlv_0= '[' ( ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' ) )
            // InternalRDL.g:1391:2: (otherlv_0= '[' ( ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' )
            {
            // InternalRDL.g:1391:2: (otherlv_0= '[' ( ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']' )
            // InternalRDL.g:1392:3: otherlv_0= '[' ( ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalRDL.g:1396:3: ( ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) ) | ( (lv_size_4_0= RULE_NUM ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_NUM) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==30) ) {
                    alt24=1;
                }
                else if ( (LA24_1==31) ) {
                    alt24=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalRDL.g:1397:4: ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) )
                    {
                    // InternalRDL.g:1397:4: ( ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) ) )
                    // InternalRDL.g:1398:5: ( (lv_start_1_0= RULE_NUM ) ) otherlv_2= ':' ( (lv_end_3_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:1398:5: ( (lv_start_1_0= RULE_NUM ) )
                    // InternalRDL.g:1399:6: (lv_start_1_0= RULE_NUM )
                    {
                    // InternalRDL.g:1399:6: (lv_start_1_0= RULE_NUM )
                    // InternalRDL.g:1400:7: lv_start_1_0= RULE_NUM
                    {
                    lv_start_1_0=(Token)match(input,RULE_NUM,FOLLOW_33); 

                    							newLeafNode(lv_start_1_0, grammarAccess.getRangeAccess().getStartNUMTerminalRuleCall_1_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRangeRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"start",
                    								lv_start_1_0,
                    								"com.minres.rdl.RDL.NUM");
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,30,FOLLOW_29); 

                    					newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getColonKeyword_1_0_1());
                    				
                    // InternalRDL.g:1420:5: ( (lv_end_3_0= RULE_NUM ) )
                    // InternalRDL.g:1421:6: (lv_end_3_0= RULE_NUM )
                    {
                    // InternalRDL.g:1421:6: (lv_end_3_0= RULE_NUM )
                    // InternalRDL.g:1422:7: lv_end_3_0= RULE_NUM
                    {
                    lv_end_3_0=(Token)match(input,RULE_NUM,FOLLOW_34); 

                    							newLeafNode(lv_end_3_0, grammarAccess.getRangeAccess().getEndNUMTerminalRuleCall_1_0_2_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRangeRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"end",
                    								lv_end_3_0,
                    								"com.minres.rdl.RDL.NUM");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:1440:4: ( (lv_size_4_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:1440:4: ( (lv_size_4_0= RULE_NUM ) )
                    // InternalRDL.g:1441:5: (lv_size_4_0= RULE_NUM )
                    {
                    // InternalRDL.g:1441:5: (lv_size_4_0= RULE_NUM )
                    // InternalRDL.g:1442:6: lv_size_4_0= RULE_NUM
                    {
                    lv_size_4_0=(Token)match(input,RULE_NUM,FOLLOW_34); 

                    						newLeafNode(lv_size_4_0, grammarAccess.getRangeAccess().getSizeNUMTerminalRuleCall_1_1_0());
                    					

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
                    break;

            }

            otherlv_5=(Token)match(input,31,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRangeAccess().getRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:1467:1: entryRulePropertyAssignment returns [EObject current=null] : iv_rulePropertyAssignment= rulePropertyAssignment EOF ;
    public final EObject entryRulePropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssignment = null;


        try {
            // InternalRDL.g:1467:59: (iv_rulePropertyAssignment= rulePropertyAssignment EOF )
            // InternalRDL.g:1468:2: iv_rulePropertyAssignment= rulePropertyAssignment EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyAssignment=rulePropertyAssignment();

            state._fsp--;

             current =iv_rulePropertyAssignment; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1474:1: rulePropertyAssignment returns [EObject current=null] : (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment ) ;
    public final EObject rulePropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_DefaultProperyAssignment_0 = null;

        EObject this_ExplicitPropertyAssignment_1 = null;

        EObject this_PostPropertyAssignment_2 = null;



        	enterRule();

        try {
            // InternalRDL.g:1480:2: ( (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment ) )
            // InternalRDL.g:1481:2: (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment )
            {
            // InternalRDL.g:1481:2: (this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment | this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment | this_PostPropertyAssignment_2= rulePostPropertyAssignment )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt25=1;
                }
                break;
            case 23:
            case 35:
            case 36:
            case 47:
            case 48:
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
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
                {
                alt25=2;
                }
                break;
            case RULE_ID:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalRDL.g:1482:3: this_DefaultProperyAssignment_0= ruleDefaultProperyAssignment
                    {

                    			newCompositeNode(grammarAccess.getPropertyAssignmentAccess().getDefaultProperyAssignmentParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DefaultProperyAssignment_0=ruleDefaultProperyAssignment();

                    state._fsp--;


                    			current = this_DefaultProperyAssignment_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRDL.g:1491:3: this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment
                    {

                    			newCompositeNode(grammarAccess.getPropertyAssignmentAccess().getExplicitPropertyAssignmentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExplicitPropertyAssignment_1=ruleExplicitPropertyAssignment();

                    state._fsp--;


                    			current = this_ExplicitPropertyAssignment_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRDL.g:1500:3: this_PostPropertyAssignment_2= rulePostPropertyAssignment
                    {

                    			newCompositeNode(grammarAccess.getPropertyAssignmentAccess().getPostPropertyAssignmentParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PostPropertyAssignment_2=rulePostPropertyAssignment();

                    state._fsp--;


                    			current = this_PostPropertyAssignment_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:1512:1: entryRuleDefaultProperyAssignment returns [EObject current=null] : iv_ruleDefaultProperyAssignment= ruleDefaultProperyAssignment EOF ;
    public final EObject entryRuleDefaultProperyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultProperyAssignment = null;


        try {
            // InternalRDL.g:1512:65: (iv_ruleDefaultProperyAssignment= ruleDefaultProperyAssignment EOF )
            // InternalRDL.g:1513:2: iv_ruleDefaultProperyAssignment= ruleDefaultProperyAssignment EOF
            {
             newCompositeNode(grammarAccess.getDefaultProperyAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefaultProperyAssignment=ruleDefaultProperyAssignment();

            state._fsp--;

             current =iv_ruleDefaultProperyAssignment; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1519:1: ruleDefaultProperyAssignment returns [EObject current=null] : (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment ) ;
    public final EObject ruleDefaultProperyAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_ExplicitPropertyAssignment_1 = null;



        	enterRule();

        try {
            // InternalRDL.g:1525:2: ( (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment ) )
            // InternalRDL.g:1526:2: (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment )
            {
            // InternalRDL.g:1526:2: (otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment )
            // InternalRDL.g:1527:3: otherlv_0= 'default' this_ExplicitPropertyAssignment_1= ruleExplicitPropertyAssignment
            {
            otherlv_0=(Token)match(input,17,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getDefaultProperyAssignmentAccess().getDefaultKeyword_0());
            		

            			newCompositeNode(grammarAccess.getDefaultProperyAssignmentAccess().getExplicitPropertyAssignmentParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            this_ExplicitPropertyAssignment_1=ruleExplicitPropertyAssignment();

            state._fsp--;


            			current = this_ExplicitPropertyAssignment_1;
            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:1543:1: entryRuleExplicitPropertyAssignment returns [EObject current=null] : iv_ruleExplicitPropertyAssignment= ruleExplicitPropertyAssignment EOF ;
    public final EObject entryRuleExplicitPropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExplicitPropertyAssignment = null;


        try {
            // InternalRDL.g:1543:67: (iv_ruleExplicitPropertyAssignment= ruleExplicitPropertyAssignment EOF )
            // InternalRDL.g:1544:2: iv_ruleExplicitPropertyAssignment= ruleExplicitPropertyAssignment EOF
            {
             newCompositeNode(grammarAccess.getExplicitPropertyAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExplicitPropertyAssignment=ruleExplicitPropertyAssignment();

            state._fsp--;

             current =iv_ruleExplicitPropertyAssignment; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1550:1: ruleExplicitPropertyAssignment returns [EObject current=null] : ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) otherlv_2= ';' ) | ( ( (lv_name_3_0= ruleProperty ) ) (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )? otherlv_6= ';' ) ) ;
    public final EObject ruleExplicitPropertyAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_modifier_0_0 = null;

        Enumerator lv_name_1_0 = null;

        Enumerator lv_name_3_0 = null;

        EObject lv_rhs_5_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1556:2: ( ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) otherlv_2= ';' ) | ( ( (lv_name_3_0= ruleProperty ) ) (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )? otherlv_6= ';' ) ) )
            // InternalRDL.g:1557:2: ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) otherlv_2= ';' ) | ( ( (lv_name_3_0= ruleProperty ) ) (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )? otherlv_6= ';' ) )
            {
            // InternalRDL.g:1557:2: ( ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) otherlv_2= ';' ) | ( ( (lv_name_3_0= ruleProperty ) ) (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )? otherlv_6= ';' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==119||(LA27_0>=128 && LA27_0<=132)) ) {
                alt27=1;
            }
            else if ( (LA27_0==23||(LA27_0>=35 && LA27_0<=36)||(LA27_0>=47 && LA27_0<=118)) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalRDL.g:1558:3: ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) otherlv_2= ';' )
                    {
                    // InternalRDL.g:1558:3: ( ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) otherlv_2= ';' )
                    // InternalRDL.g:1559:4: ( (lv_modifier_0_0= rulePropertyModifier ) ) ( (lv_name_1_0= ruleProperty ) ) otherlv_2= ';'
                    {
                    // InternalRDL.g:1559:4: ( (lv_modifier_0_0= rulePropertyModifier ) )
                    // InternalRDL.g:1560:5: (lv_modifier_0_0= rulePropertyModifier )
                    {
                    // InternalRDL.g:1560:5: (lv_modifier_0_0= rulePropertyModifier )
                    // InternalRDL.g:1561:6: lv_modifier_0_0= rulePropertyModifier
                    {

                    						newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getModifierPropertyModifierEnumRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_modifier_0_0=rulePropertyModifier();

                    state._fsp--;


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

                    // InternalRDL.g:1578:4: ( (lv_name_1_0= ruleProperty ) )
                    // InternalRDL.g:1579:5: (lv_name_1_0= ruleProperty )
                    {
                    // InternalRDL.g:1579:5: (lv_name_1_0= ruleProperty )
                    // InternalRDL.g:1580:6: lv_name_1_0= ruleProperty
                    {

                    						newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getNamePropertyEnumRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_name_1_0=ruleProperty();

                    state._fsp--;


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

                    otherlv_2=(Token)match(input,15,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getExplicitPropertyAssignmentAccess().getSemicolonKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:1603:3: ( ( (lv_name_3_0= ruleProperty ) ) (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )? otherlv_6= ';' )
                    {
                    // InternalRDL.g:1603:3: ( ( (lv_name_3_0= ruleProperty ) ) (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )? otherlv_6= ';' )
                    // InternalRDL.g:1604:4: ( (lv_name_3_0= ruleProperty ) ) (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )? otherlv_6= ';'
                    {
                    // InternalRDL.g:1604:4: ( (lv_name_3_0= ruleProperty ) )
                    // InternalRDL.g:1605:5: (lv_name_3_0= ruleProperty )
                    {
                    // InternalRDL.g:1605:5: (lv_name_3_0= ruleProperty )
                    // InternalRDL.g:1606:6: lv_name_3_0= ruleProperty
                    {

                    						newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getNamePropertyEnumRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_name_3_0=ruleProperty();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExplicitPropertyAssignmentRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"com.minres.rdl.RDL.Property");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRDL.g:1623:4: (otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==14) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalRDL.g:1624:5: otherlv_4= '=' ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) )
                            {
                            otherlv_4=(Token)match(input,14,FOLLOW_37); 

                            					newLeafNode(otherlv_4, grammarAccess.getExplicitPropertyAssignmentAccess().getEqualsSignKeyword_1_1_0());
                            				
                            // InternalRDL.g:1628:5: ( (lv_rhs_5_0= rulePropertyAssignmentRhs ) )
                            // InternalRDL.g:1629:6: (lv_rhs_5_0= rulePropertyAssignmentRhs )
                            {
                            // InternalRDL.g:1629:6: (lv_rhs_5_0= rulePropertyAssignmentRhs )
                            // InternalRDL.g:1630:7: lv_rhs_5_0= rulePropertyAssignmentRhs
                            {

                            							newCompositeNode(grammarAccess.getExplicitPropertyAssignmentAccess().getRhsPropertyAssignmentRhsParserRuleCall_1_1_1_0());
                            						
                            pushFollow(FOLLOW_10);
                            lv_rhs_5_0=rulePropertyAssignmentRhs();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getExplicitPropertyAssignmentRule());
                            							}
                            							set(
                            								current,
                            								"rhs",
                            								lv_rhs_5_0,
                            								"com.minres.rdl.RDL.PropertyAssignmentRhs");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,15,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getExplicitPropertyAssignmentAccess().getSemicolonKeyword_1_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:1657:1: entryRulePostPropertyAssignment returns [EObject current=null] : iv_rulePostPropertyAssignment= rulePostPropertyAssignment EOF ;
    public final EObject entryRulePostPropertyAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostPropertyAssignment = null;


        try {
            // InternalRDL.g:1657:63: (iv_rulePostPropertyAssignment= rulePostPropertyAssignment EOF )
            // InternalRDL.g:1658:2: iv_rulePostPropertyAssignment= rulePostPropertyAssignment EOF
            {
             newCompositeNode(grammarAccess.getPostPropertyAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePostPropertyAssignment=rulePostPropertyAssignment();

            state._fsp--;

             current =iv_rulePostPropertyAssignment; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1664:1: rulePostPropertyAssignment returns [EObject current=null] : ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? otherlv_7= ';' ) ;
    public final EObject rulePostPropertyAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_instance_0_0 = null;

        Enumerator lv_propertyEnum_2_0 = null;

        EObject lv_rhs_6_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1670:2: ( ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? otherlv_7= ';' ) )
            // InternalRDL.g:1671:2: ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? otherlv_7= ';' )
            {
            // InternalRDL.g:1671:2: ( ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? otherlv_7= ';' )
            // InternalRDL.g:1672:3: ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )? otherlv_7= ';'
            {
            // InternalRDL.g:1672:3: ( ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) ) | ( (otherlv_4= RULE_ID ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( ((LA29_1>=14 && LA29_1<=15)) ) {
                    alt29=2;
                }
                else if ( ((LA29_1>=32 && LA29_1<=33)) ) {
                    alt29=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalRDL.g:1673:4: ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )
                    {
                    // InternalRDL.g:1673:4: ( ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )
                    // InternalRDL.g:1674:5: ( (lv_instance_0_0= ruleHierInstanceRef ) ) otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    {
                    // InternalRDL.g:1674:5: ( (lv_instance_0_0= ruleHierInstanceRef ) )
                    // InternalRDL.g:1675:6: (lv_instance_0_0= ruleHierInstanceRef )
                    {
                    // InternalRDL.g:1675:6: (lv_instance_0_0= ruleHierInstanceRef )
                    // InternalRDL.g:1676:7: lv_instance_0_0= ruleHierInstanceRef
                    {

                    							newCompositeNode(grammarAccess.getPostPropertyAssignmentAccess().getInstanceHierInstanceRefParserRuleCall_0_0_0_0());
                    						
                    pushFollow(FOLLOW_38);
                    lv_instance_0_0=ruleHierInstanceRef();

                    state._fsp--;


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

                    otherlv_1=(Token)match(input,32,FOLLOW_39); 

                    					newLeafNode(otherlv_1, grammarAccess.getPostPropertyAssignmentAccess().getHyphenMinusGreaterThanSignKeyword_0_0_1());
                    				
                    // InternalRDL.g:1697:5: ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==23||(LA28_0>=35 && LA28_0<=36)||(LA28_0>=47 && LA28_0<=118)) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==RULE_ID) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalRDL.g:1698:6: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            {
                            // InternalRDL.g:1698:6: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            // InternalRDL.g:1699:7: (lv_propertyEnum_2_0= ruleProperty )
                            {
                            // InternalRDL.g:1699:7: (lv_propertyEnum_2_0= ruleProperty )
                            // InternalRDL.g:1700:8: lv_propertyEnum_2_0= ruleProperty
                            {

                            								newCompositeNode(grammarAccess.getPostPropertyAssignmentAccess().getPropertyEnumPropertyEnumRuleCall_0_0_2_0_0());
                            							
                            pushFollow(FOLLOW_36);
                            lv_propertyEnum_2_0=ruleProperty();

                            state._fsp--;


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
                            break;
                        case 2 :
                            // InternalRDL.g:1718:6: ( (otherlv_3= RULE_ID ) )
                            {
                            // InternalRDL.g:1718:6: ( (otherlv_3= RULE_ID ) )
                            // InternalRDL.g:1719:7: (otherlv_3= RULE_ID )
                            {
                            // InternalRDL.g:1719:7: (otherlv_3= RULE_ID )
                            // InternalRDL.g:1720:8: otherlv_3= RULE_ID
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getPostPropertyAssignmentRule());
                            								}
                            							
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_36); 

                            								newLeafNode(otherlv_3, grammarAccess.getPostPropertyAssignmentAccess().getPropertyPropertyDefinitionCrossReference_0_0_2_1_0());
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:1734:4: ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalRDL.g:1734:4: ( (otherlv_4= RULE_ID ) )
                    // InternalRDL.g:1735:5: (otherlv_4= RULE_ID )
                    {
                    // InternalRDL.g:1735:5: (otherlv_4= RULE_ID )
                    // InternalRDL.g:1736:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPostPropertyAssignmentRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_36); 

                    						newLeafNode(otherlv_4, grammarAccess.getPostPropertyAssignmentAccess().getPropertyPropertyDefinitionCrossReference_0_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRDL.g:1748:3: (otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==14) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRDL.g:1749:4: otherlv_5= '=' ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_37); 

                    				newLeafNode(otherlv_5, grammarAccess.getPostPropertyAssignmentAccess().getEqualsSignKeyword_1_0());
                    			
                    // InternalRDL.g:1753:4: ( (lv_rhs_6_0= rulePropertyAssignmentRhs ) )
                    // InternalRDL.g:1754:5: (lv_rhs_6_0= rulePropertyAssignmentRhs )
                    {
                    // InternalRDL.g:1754:5: (lv_rhs_6_0= rulePropertyAssignmentRhs )
                    // InternalRDL.g:1755:6: lv_rhs_6_0= rulePropertyAssignmentRhs
                    {

                    						newCompositeNode(grammarAccess.getPostPropertyAssignmentAccess().getRhsPropertyAssignmentRhsParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_rhs_6_0=rulePropertyAssignmentRhs();

                    state._fsp--;


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
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getPostPropertyAssignmentAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:1781:1: entryRuleInstancePropertyRef returns [EObject current=null] : iv_ruleInstancePropertyRef= ruleInstancePropertyRef EOF ;
    public final EObject entryRuleInstancePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstancePropertyRef = null;


        try {
            // InternalRDL.g:1781:60: (iv_ruleInstancePropertyRef= ruleInstancePropertyRef EOF )
            // InternalRDL.g:1782:2: iv_ruleInstancePropertyRef= ruleInstancePropertyRef EOF
            {
             newCompositeNode(grammarAccess.getInstancePropertyRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstancePropertyRef=ruleInstancePropertyRef();

            state._fsp--;

             current =iv_ruleInstancePropertyRef; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1788:1: ruleInstancePropertyRef returns [EObject current=null] : ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? ) ;
    public final EObject ruleInstancePropertyRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_instance_0_0 = null;

        Enumerator lv_propertyEnum_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1794:2: ( ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? ) )
            // InternalRDL.g:1795:2: ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? )
            {
            // InternalRDL.g:1795:2: ( ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )? )
            // InternalRDL.g:1796:3: ( (lv_instance_0_0= ruleInstanceRef ) ) (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )?
            {
            // InternalRDL.g:1796:3: ( (lv_instance_0_0= ruleInstanceRef ) )
            // InternalRDL.g:1797:4: (lv_instance_0_0= ruleInstanceRef )
            {
            // InternalRDL.g:1797:4: (lv_instance_0_0= ruleInstanceRef )
            // InternalRDL.g:1798:5: lv_instance_0_0= ruleInstanceRef
            {

            					newCompositeNode(grammarAccess.getInstancePropertyRefAccess().getInstanceInstanceRefParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_40);
            lv_instance_0_0=ruleInstanceRef();

            state._fsp--;


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

            // InternalRDL.g:1815:3: (otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==32) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalRDL.g:1816:4: otherlv_1= '->' ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_39); 

                    				newLeafNode(otherlv_1, grammarAccess.getInstancePropertyRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                    			
                    // InternalRDL.g:1820:4: ( ( (lv_propertyEnum_2_0= ruleProperty ) ) | ( (otherlv_3= RULE_ID ) ) )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==23||(LA31_0>=35 && LA31_0<=36)||(LA31_0>=47 && LA31_0<=118)) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RULE_ID) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalRDL.g:1821:5: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            {
                            // InternalRDL.g:1821:5: ( (lv_propertyEnum_2_0= ruleProperty ) )
                            // InternalRDL.g:1822:6: (lv_propertyEnum_2_0= ruleProperty )
                            {
                            // InternalRDL.g:1822:6: (lv_propertyEnum_2_0= ruleProperty )
                            // InternalRDL.g:1823:7: lv_propertyEnum_2_0= ruleProperty
                            {

                            							newCompositeNode(grammarAccess.getInstancePropertyRefAccess().getPropertyEnumPropertyEnumRuleCall_1_1_0_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_propertyEnum_2_0=ruleProperty();

                            state._fsp--;


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
                            break;
                        case 2 :
                            // InternalRDL.g:1841:5: ( (otherlv_3= RULE_ID ) )
                            {
                            // InternalRDL.g:1841:5: ( (otherlv_3= RULE_ID ) )
                            // InternalRDL.g:1842:6: (otherlv_3= RULE_ID )
                            {
                            // InternalRDL.g:1842:6: (otherlv_3= RULE_ID )
                            // InternalRDL.g:1843:7: otherlv_3= RULE_ID
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getInstancePropertyRefRule());
                            							}
                            						
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                            							newLeafNode(otherlv_3, grammarAccess.getInstancePropertyRefAccess().getPropertyPropertyDefinitionCrossReference_1_1_1_0());
                            						

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


            	leaveRule();

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
    // InternalRDL.g:1860:1: entryRuleInstanceRef returns [EObject current=null] : iv_ruleInstanceRef= ruleInstanceRef EOF ;
    public final EObject entryRuleInstanceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceRef = null;


        try {
            // InternalRDL.g:1860:52: (iv_ruleInstanceRef= ruleInstanceRef EOF )
            // InternalRDL.g:1861:2: iv_ruleInstanceRef= ruleInstanceRef EOF
            {
             newCompositeNode(grammarAccess.getInstanceRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstanceRef=ruleInstanceRef();

            state._fsp--;

             current =iv_ruleInstanceRef; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1867:1: ruleInstanceRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) ;
    public final EObject ruleInstanceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_tail_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1873:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) )
            // InternalRDL.g:1874:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            {
            // InternalRDL.g:1874:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            // InternalRDL.g:1875:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            {
            // InternalRDL.g:1875:3: ( (otherlv_0= RULE_ID ) )
            // InternalRDL.g:1876:4: (otherlv_0= RULE_ID )
            {
            // InternalRDL.g:1876:4: (otherlv_0= RULE_ID )
            // InternalRDL.g:1877:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInstanceRefRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_0, grammarAccess.getInstanceRefAccess().getInstanceEntityCrossReference_0_0());
            				

            }


            }

            // InternalRDL.g:1888:3: (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==33) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRDL.g:1889:4: otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0());
                    			
                    // InternalRDL.g:1893:4: ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    // InternalRDL.g:1894:5: (lv_tail_2_0= ruleHierInstanceRef )
                    {
                    // InternalRDL.g:1894:5: (lv_tail_2_0= ruleHierInstanceRef )
                    // InternalRDL.g:1895:6: lv_tail_2_0= ruleHierInstanceRef
                    {

                    						newCompositeNode(grammarAccess.getInstanceRefAccess().getTailHierInstanceRefParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_tail_2_0=ruleHierInstanceRef();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRDL.g:1917:1: entryRuleHierInstanceRef returns [EObject current=null] : iv_ruleHierInstanceRef= ruleHierInstanceRef EOF ;
    public final EObject entryRuleHierInstanceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHierInstanceRef = null;


        try {
            // InternalRDL.g:1917:56: (iv_ruleHierInstanceRef= ruleHierInstanceRef EOF )
            // InternalRDL.g:1918:2: iv_ruleHierInstanceRef= ruleHierInstanceRef EOF
            {
             newCompositeNode(grammarAccess.getHierInstanceRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHierInstanceRef=ruleHierInstanceRef();

            state._fsp--;

             current =iv_ruleHierInstanceRef; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1924:1: ruleHierInstanceRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) ;
    public final EObject ruleHierInstanceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_tail_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:1930:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? ) )
            // InternalRDL.g:1931:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            {
            // InternalRDL.g:1931:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )? )
            // InternalRDL.g:1932:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            {
            // InternalRDL.g:1932:3: ( (otherlv_0= RULE_ID ) )
            // InternalRDL.g:1933:4: (otherlv_0= RULE_ID )
            {
            // InternalRDL.g:1933:4: (otherlv_0= RULE_ID )
            // InternalRDL.g:1934:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHierInstanceRefRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_0, grammarAccess.getHierInstanceRefAccess().getInstanceComponentInstanceCrossReference_0_0());
            				

            }


            }

            // InternalRDL.g:1945:3: (otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==33) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalRDL.g:1946:4: otherlv_1= '.' ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getHierInstanceRefAccess().getFullStopKeyword_1_0());
                    			
                    // InternalRDL.g:1950:4: ( (lv_tail_2_0= ruleHierInstanceRef ) )
                    // InternalRDL.g:1951:5: (lv_tail_2_0= ruleHierInstanceRef )
                    {
                    // InternalRDL.g:1951:5: (lv_tail_2_0= ruleHierInstanceRef )
                    // InternalRDL.g:1952:6: lv_tail_2_0= ruleHierInstanceRef
                    {

                    						newCompositeNode(grammarAccess.getHierInstanceRefAccess().getTailHierInstanceRefParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_tail_2_0=ruleHierInstanceRef();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRDL.g:1974:1: entryRulePropertyAssignmentRhs returns [EObject current=null] : iv_rulePropertyAssignmentRhs= rulePropertyAssignmentRhs EOF ;
    public final EObject entryRulePropertyAssignmentRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssignmentRhs = null;


        try {
            // InternalRDL.g:1974:62: (iv_rulePropertyAssignmentRhs= rulePropertyAssignmentRhs EOF )
            // InternalRDL.g:1975:2: iv_rulePropertyAssignmentRhs= rulePropertyAssignmentRhs EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssignmentRhsRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyAssignmentRhs=rulePropertyAssignmentRhs();

            state._fsp--;

             current =iv_rulePropertyAssignmentRhs; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:1981:1: rulePropertyAssignmentRhs returns [EObject current=null] : ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) ) ;
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
            // InternalRDL.g:1987:2: ( ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) ) )
            // InternalRDL.g:1988:2: ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) )
            {
            // InternalRDL.g:1988:2: ( ( (lv_value_0_0= rulePropertyRvalueConstant ) ) | ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) ) | ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) ) | ( (lv_elements_5_0= ruleConcat ) ) )
            int alt35=4;
            switch ( input.LA(1) ) {
            case RULE_STR:
            case RULE_NUM:
            case 18:
            case 19:
            case 104:
            case 105:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
                {
                alt35=1;
                }
                break;
            case RULE_ID:
                {
                int LA35_2 = input.LA(2);

                if ( (LA35_2==34) ) {
                    alt35=3;
                }
                else if ( (LA35_2==EOF||LA35_2==15||(LA35_2>=32 && LA35_2<=33)) ) {
                    alt35=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 2, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalRDL.g:1989:3: ( (lv_value_0_0= rulePropertyRvalueConstant ) )
                    {
                    // InternalRDL.g:1989:3: ( (lv_value_0_0= rulePropertyRvalueConstant ) )
                    // InternalRDL.g:1990:4: (lv_value_0_0= rulePropertyRvalueConstant )
                    {
                    // InternalRDL.g:1990:4: (lv_value_0_0= rulePropertyRvalueConstant )
                    // InternalRDL.g:1991:5: lv_value_0_0= rulePropertyRvalueConstant
                    {

                    					newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getValuePropertyRvalueConstantParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=rulePropertyRvalueConstant();

                    state._fsp--;


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
                    break;
                case 2 :
                    // InternalRDL.g:2009:3: ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) )
                    {
                    // InternalRDL.g:2009:3: ( (lv_instPropRef_1_0= ruleInstancePropertyRef ) )
                    // InternalRDL.g:2010:4: (lv_instPropRef_1_0= ruleInstancePropertyRef )
                    {
                    // InternalRDL.g:2010:4: (lv_instPropRef_1_0= ruleInstancePropertyRef )
                    // InternalRDL.g:2011:5: lv_instPropRef_1_0= ruleInstancePropertyRef
                    {

                    					newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getInstPropRefInstancePropertyRefParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_instPropRef_1_0=ruleInstancePropertyRef();

                    state._fsp--;


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
                    break;
                case 3 :
                    // InternalRDL.g:2029:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) )
                    {
                    // InternalRDL.g:2029:3: ( ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) ) )
                    // InternalRDL.g:2030:4: ( (otherlv_2= RULE_ID ) ) otherlv_3= 'enum' ( (lv_enums_4_0= ruleEnumBody ) )
                    {
                    // InternalRDL.g:2030:4: ( (otherlv_2= RULE_ID ) )
                    // InternalRDL.g:2031:5: (otherlv_2= RULE_ID )
                    {
                    // InternalRDL.g:2031:5: (otherlv_2= RULE_ID )
                    // InternalRDL.g:2032:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPropertyAssignmentRhsRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_2, grammarAccess.getPropertyAssignmentRhsAccess().getEnumRefEnumDefinitionCrossReference_2_0_0());
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,34,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getPropertyAssignmentRhsAccess().getEnumKeyword_2_1());
                    			
                    // InternalRDL.g:2047:4: ( (lv_enums_4_0= ruleEnumBody ) )
                    // InternalRDL.g:2048:5: (lv_enums_4_0= ruleEnumBody )
                    {
                    // InternalRDL.g:2048:5: (lv_enums_4_0= ruleEnumBody )
                    // InternalRDL.g:2049:6: lv_enums_4_0= ruleEnumBody
                    {

                    						newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getEnumsEnumBodyParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_enums_4_0=ruleEnumBody();

                    state._fsp--;


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
                    break;
                case 4 :
                    // InternalRDL.g:2068:3: ( (lv_elements_5_0= ruleConcat ) )
                    {
                    // InternalRDL.g:2068:3: ( (lv_elements_5_0= ruleConcat ) )
                    // InternalRDL.g:2069:4: (lv_elements_5_0= ruleConcat )
                    {
                    // InternalRDL.g:2069:4: (lv_elements_5_0= ruleConcat )
                    // InternalRDL.g:2070:5: lv_elements_5_0= ruleConcat
                    {

                    					newCompositeNode(grammarAccess.getPropertyAssignmentRhsAccess().getElementsConcatParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_elements_5_0=ruleConcat();

                    state._fsp--;


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
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2091:1: entryRuleConcat returns [EObject current=null] : iv_ruleConcat= ruleConcat EOF ;
    public final EObject entryRuleConcat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcat = null;


        try {
            // InternalRDL.g:2091:47: (iv_ruleConcat= ruleConcat EOF )
            // InternalRDL.g:2092:2: iv_ruleConcat= ruleConcat EOF
            {
             newCompositeNode(grammarAccess.getConcatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcat=ruleConcat();

            state._fsp--;

             current =iv_ruleConcat; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:2098:1: ruleConcat returns [EObject current=null] : (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleConcat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2104:2: ( (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' ) )
            // InternalRDL.g:2105:2: (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' )
            {
            // InternalRDL.g:2105:2: (otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}' )
            // InternalRDL.g:2106:3: otherlv_0= '{' ( (lv_elements_1_0= ruleConcatElem ) ) (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_43); 

            			newLeafNode(otherlv_0, grammarAccess.getConcatAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalRDL.g:2110:3: ( (lv_elements_1_0= ruleConcatElem ) )
            // InternalRDL.g:2111:4: (lv_elements_1_0= ruleConcatElem )
            {
            // InternalRDL.g:2111:4: (lv_elements_1_0= ruleConcatElem )
            // InternalRDL.g:2112:5: lv_elements_1_0= ruleConcatElem
            {

            					newCompositeNode(grammarAccess.getConcatAccess().getElementsConcatElemParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_44);
            lv_elements_1_0=ruleConcatElem();

            state._fsp--;


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

            // InternalRDL.g:2129:3: (otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==25) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalRDL.g:2130:4: otherlv_2= ',' ( (lv_elements_3_0= ruleConcatElem ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_43); 

            	    				newLeafNode(otherlv_2, grammarAccess.getConcatAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRDL.g:2134:4: ( (lv_elements_3_0= ruleConcatElem ) )
            	    // InternalRDL.g:2135:5: (lv_elements_3_0= ruleConcatElem )
            	    {
            	    // InternalRDL.g:2135:5: (lv_elements_3_0= ruleConcatElem )
            	    // InternalRDL.g:2136:6: lv_elements_3_0= ruleConcatElem
            	    {

            	    						newCompositeNode(grammarAccess.getConcatAccess().getElementsConcatElemParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
            	    lv_elements_3_0=ruleConcatElem();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getConcatAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2162:1: entryRuleConcatElem returns [EObject current=null] : iv_ruleConcatElem= ruleConcatElem EOF ;
    public final EObject entryRuleConcatElem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatElem = null;


        try {
            // InternalRDL.g:2162:51: (iv_ruleConcatElem= ruleConcatElem EOF )
            // InternalRDL.g:2163:2: iv_ruleConcatElem= ruleConcatElem EOF
            {
             newCompositeNode(grammarAccess.getConcatElemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcatElem=ruleConcatElem();

            state._fsp--;

             current =iv_ruleConcatElem; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:2169:1: ruleConcatElem returns [EObject current=null] : ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) ) ;
    public final EObject ruleConcatElem() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_instPropRef_0_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2175:2: ( ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) ) )
            // InternalRDL.g:2176:2: ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) )
            {
            // InternalRDL.g:2176:2: ( ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) ) | ( (lv_value_1_0= RULE_NUM ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_NUM) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalRDL.g:2177:3: ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) )
                    {
                    // InternalRDL.g:2177:3: ( (lv_instPropRef_0_0= ruleInstancePropertyRef ) )
                    // InternalRDL.g:2178:4: (lv_instPropRef_0_0= ruleInstancePropertyRef )
                    {
                    // InternalRDL.g:2178:4: (lv_instPropRef_0_0= ruleInstancePropertyRef )
                    // InternalRDL.g:2179:5: lv_instPropRef_0_0= ruleInstancePropertyRef
                    {

                    					newCompositeNode(grammarAccess.getConcatElemAccess().getInstPropRefInstancePropertyRefParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_instPropRef_0_0=ruleInstancePropertyRef();

                    state._fsp--;


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
                    break;
                case 2 :
                    // InternalRDL.g:2197:3: ( (lv_value_1_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:2197:3: ( (lv_value_1_0= RULE_NUM ) )
                    // InternalRDL.g:2198:4: (lv_value_1_0= RULE_NUM )
                    {
                    // InternalRDL.g:2198:4: (lv_value_1_0= RULE_NUM )
                    // InternalRDL.g:2199:5: lv_value_1_0= RULE_NUM
                    {
                    lv_value_1_0=(Token)match(input,RULE_NUM,FOLLOW_2); 

                    					newLeafNode(lv_value_1_0, grammarAccess.getConcatElemAccess().getValueNUMTerminalRuleCall_1_0());
                    				

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
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2219:1: entryRulePropertyRvalueConstant returns [EObject current=null] : iv_rulePropertyRvalueConstant= rulePropertyRvalueConstant EOF ;
    public final EObject entryRulePropertyRvalueConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRvalueConstant = null;


        try {
            // InternalRDL.g:2219:63: (iv_rulePropertyRvalueConstant= rulePropertyRvalueConstant EOF )
            // InternalRDL.g:2220:2: iv_rulePropertyRvalueConstant= rulePropertyRvalueConstant EOF
            {
             newCompositeNode(grammarAccess.getPropertyRvalueConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyRvalueConstant=rulePropertyRvalueConstant();

            state._fsp--;

             current =iv_rulePropertyRvalueConstant; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:2226:1: rulePropertyRvalueConstant returns [EObject current=null] : ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) ) ;
    public final EObject rulePropertyRvalueConstant() throws RecognitionException {
        EObject current = null;

        Token lv_num_1_0=null;
        Token lv_str_2_0=null;
        Enumerator lv_val_0_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2232:2: ( ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) ) )
            // InternalRDL.g:2233:2: ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) )
            {
            // InternalRDL.g:2233:2: ( ( (lv_val_0_0= ruleRValueConstant ) ) | ( (lv_num_1_0= RULE_NUM ) ) | ( (lv_str_2_0= RULE_STR ) ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 18:
            case 19:
            case 104:
            case 105:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
                {
                alt38=1;
                }
                break;
            case RULE_NUM:
                {
                alt38=2;
                }
                break;
            case RULE_STR:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalRDL.g:2234:3: ( (lv_val_0_0= ruleRValueConstant ) )
                    {
                    // InternalRDL.g:2234:3: ( (lv_val_0_0= ruleRValueConstant ) )
                    // InternalRDL.g:2235:4: (lv_val_0_0= ruleRValueConstant )
                    {
                    // InternalRDL.g:2235:4: (lv_val_0_0= ruleRValueConstant )
                    // InternalRDL.g:2236:5: lv_val_0_0= ruleRValueConstant
                    {

                    					newCompositeNode(grammarAccess.getPropertyRvalueConstantAccess().getValRValueConstantEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_val_0_0=ruleRValueConstant();

                    state._fsp--;


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
                    break;
                case 2 :
                    // InternalRDL.g:2254:3: ( (lv_num_1_0= RULE_NUM ) )
                    {
                    // InternalRDL.g:2254:3: ( (lv_num_1_0= RULE_NUM ) )
                    // InternalRDL.g:2255:4: (lv_num_1_0= RULE_NUM )
                    {
                    // InternalRDL.g:2255:4: (lv_num_1_0= RULE_NUM )
                    // InternalRDL.g:2256:5: lv_num_1_0= RULE_NUM
                    {
                    lv_num_1_0=(Token)match(input,RULE_NUM,FOLLOW_2); 

                    					newLeafNode(lv_num_1_0, grammarAccess.getPropertyRvalueConstantAccess().getNumNUMTerminalRuleCall_1_0());
                    				

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
                    break;
                case 3 :
                    // InternalRDL.g:2273:3: ( (lv_str_2_0= RULE_STR ) )
                    {
                    // InternalRDL.g:2273:3: ( (lv_str_2_0= RULE_STR ) )
                    // InternalRDL.g:2274:4: (lv_str_2_0= RULE_STR )
                    {
                    // InternalRDL.g:2274:4: (lv_str_2_0= RULE_STR )
                    // InternalRDL.g:2275:5: lv_str_2_0= RULE_STR
                    {
                    lv_str_2_0=(Token)match(input,RULE_STR,FOLLOW_2); 

                    					newLeafNode(lv_str_2_0, grammarAccess.getPropertyRvalueConstantAccess().getStrSTRTerminalRuleCall_2_0());
                    				

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
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2295:1: entryRuleEnumDefinition returns [EObject current=null] : iv_ruleEnumDefinition= ruleEnumDefinition EOF ;
    public final EObject entryRuleEnumDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumDefinition = null;


        try {
            // InternalRDL.g:2295:55: (iv_ruleEnumDefinition= ruleEnumDefinition EOF )
            // InternalRDL.g:2296:2: iv_ruleEnumDefinition= ruleEnumDefinition EOF
            {
             newCompositeNode(grammarAccess.getEnumDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumDefinition=ruleEnumDefinition();

            state._fsp--;

             current =iv_ruleEnumDefinition; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:2302:1: ruleEnumDefinition returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) otherlv_3= ';' ) ;
    public final EObject ruleEnumDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2308:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) otherlv_3= ';' ) )
            // InternalRDL.g:2309:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) otherlv_3= ';' )
            {
            // InternalRDL.g:2309:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) otherlv_3= ';' )
            // InternalRDL.g:2310:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) ( (lv_body_2_0= ruleEnumBody ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumDefinitionAccess().getEnumKeyword_0());
            		
            // InternalRDL.g:2314:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRDL.g:2315:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRDL.g:2315:4: (lv_name_1_0= RULE_ID )
            // InternalRDL.g:2316:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

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

            // InternalRDL.g:2332:3: ( (lv_body_2_0= ruleEnumBody ) )
            // InternalRDL.g:2333:4: (lv_body_2_0= ruleEnumBody )
            {
            // InternalRDL.g:2333:4: (lv_body_2_0= ruleEnumBody )
            // InternalRDL.g:2334:5: lv_body_2_0= ruleEnumBody
            {

            					newCompositeNode(grammarAccess.getEnumDefinitionAccess().getBodyEnumBodyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_10);
            lv_body_2_0=ruleEnumBody();

            state._fsp--;


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

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumDefinitionAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2359:1: entryRuleEnumBody returns [EObject current=null] : iv_ruleEnumBody= ruleEnumBody EOF ;
    public final EObject entryRuleEnumBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBody = null;


        try {
            // InternalRDL.g:2359:49: (iv_ruleEnumBody= ruleEnumBody EOF )
            // InternalRDL.g:2360:2: iv_ruleEnumBody= ruleEnumBody EOF
            {
             newCompositeNode(grammarAccess.getEnumBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumBody=ruleEnumBody();

            state._fsp--;

             current =iv_ruleEnumBody; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:2366:1: ruleEnumBody returns [EObject current=null] : (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' ) ;
    public final EObject ruleEnumBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRDL.g:2372:2: ( (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' ) )
            // InternalRDL.g:2373:2: (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' )
            {
            // InternalRDL.g:2373:2: (otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}' )
            // InternalRDL.g:2374:3: otherlv_0= '{' () ( (lv_entries_2_0= ruleEnumEntry ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumBodyAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalRDL.g:2378:3: ()
            // InternalRDL.g:2379:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumBodyAccess().getEnumBodyAction_1(),
            					current);
            			

            }

            // InternalRDL.g:2385:3: ( (lv_entries_2_0= ruleEnumEntry ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalRDL.g:2386:4: (lv_entries_2_0= ruleEnumEntry )
            	    {
            	    // InternalRDL.g:2386:4: (lv_entries_2_0= ruleEnumEntry )
            	    // InternalRDL.g:2387:5: lv_entries_2_0= ruleEnumEntry
            	    {

            	    					newCompositeNode(grammarAccess.getEnumBodyAccess().getEntriesEnumEntryParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_45);
            	    lv_entries_2_0=ruleEnumEntry();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumBodyAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2412:1: entryRuleEnumEntry returns [EObject current=null] : iv_ruleEnumEntry= ruleEnumEntry EOF ;
    public final EObject entryRuleEnumEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumEntry = null;


        try {
            // InternalRDL.g:2412:50: (iv_ruleEnumEntry= ruleEnumEntry EOF )
            // InternalRDL.g:2413:2: iv_ruleEnumEntry= ruleEnumEntry EOF
            {
             newCompositeNode(grammarAccess.getEnumEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumEntry=ruleEnumEntry();

            state._fsp--;

             current =iv_ruleEnumEntry; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:2419:1: ruleEnumEntry returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' ) ;
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
            // InternalRDL.g:2425:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' ) )
            // InternalRDL.g:2426:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' )
            {
            // InternalRDL.g:2426:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';' )
            // InternalRDL.g:2427:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_index_2_0= RULE_NUM ) ) (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )? otherlv_6= ';'
            {
            // InternalRDL.g:2427:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalRDL.g:2428:4: (lv_name_0_0= RULE_ID )
            {
            // InternalRDL.g:2428:4: (lv_name_0_0= RULE_ID )
            // InternalRDL.g:2429:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEnumEntryAccess().getNameIDTerminalRuleCall_0_0());
            				

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

            otherlv_1=(Token)match(input,14,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumEntryAccess().getEqualsSignKeyword_1());
            		
            // InternalRDL.g:2449:3: ( (lv_index_2_0= RULE_NUM ) )
            // InternalRDL.g:2450:4: (lv_index_2_0= RULE_NUM )
            {
            // InternalRDL.g:2450:4: (lv_index_2_0= RULE_NUM )
            // InternalRDL.g:2451:5: lv_index_2_0= RULE_NUM
            {
            lv_index_2_0=(Token)match(input,RULE_NUM,FOLLOW_46); 

            					newLeafNode(lv_index_2_0, grammarAccess.getEnumEntryAccess().getIndexNUMTerminalRuleCall_2_0());
            				

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

            // InternalRDL.g:2467:3: (otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==12) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRDL.g:2468:4: otherlv_3= '{' ( (lv_properties_4_0= ruleEnumProperty ) )* otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_47); 

                    				newLeafNode(otherlv_3, grammarAccess.getEnumEntryAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalRDL.g:2472:4: ( (lv_properties_4_0= ruleEnumProperty ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=35 && LA40_0<=36)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalRDL.g:2473:5: (lv_properties_4_0= ruleEnumProperty )
                    	    {
                    	    // InternalRDL.g:2473:5: (lv_properties_4_0= ruleEnumProperty )
                    	    // InternalRDL.g:2474:6: lv_properties_4_0= ruleEnumProperty
                    	    {

                    	    						newCompositeNode(grammarAccess.getEnumEntryAccess().getPropertiesEnumPropertyParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_47);
                    	    lv_properties_4_0=ruleEnumProperty();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,16,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getEnumEntryAccess().getRightCurlyBracketKeyword_3_2());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getEnumEntryAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2504:1: entryRuleEnumProperty returns [EObject current=null] : iv_ruleEnumProperty= ruleEnumProperty EOF ;
    public final EObject entryRuleEnumProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumProperty = null;


        try {
            // InternalRDL.g:2504:53: (iv_ruleEnumProperty= ruleEnumProperty EOF )
            // InternalRDL.g:2505:2: iv_ruleEnumProperty= ruleEnumProperty EOF
            {
             newCompositeNode(grammarAccess.getEnumPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumProperty=ruleEnumProperty();

            state._fsp--;

             current =iv_ruleEnumProperty; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalRDL.g:2511:1: ruleEnumProperty returns [EObject current=null] : ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' ) ;
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
            // InternalRDL.g:2517:2: ( ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' ) )
            // InternalRDL.g:2518:2: ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' )
            {
            // InternalRDL.g:2518:2: ( ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';' )
            // InternalRDL.g:2519:3: ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) ) otherlv_6= ';'
            {
            // InternalRDL.g:2519:3: ( ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) ) | ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==35) ) {
                alt42=1;
            }
            else if ( (LA42_0==36) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalRDL.g:2520:4: ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) )
                    {
                    // InternalRDL.g:2520:4: ( ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) ) )
                    // InternalRDL.g:2521:5: ( (lv_name_0_0= 'name' ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STR ) )
                    {
                    // InternalRDL.g:2521:5: ( (lv_name_0_0= 'name' ) )
                    // InternalRDL.g:2522:6: (lv_name_0_0= 'name' )
                    {
                    // InternalRDL.g:2522:6: (lv_name_0_0= 'name' )
                    // InternalRDL.g:2523:7: lv_name_0_0= 'name'
                    {
                    lv_name_0_0=(Token)match(input,35,FOLLOW_8); 

                    							newLeafNode(lv_name_0_0, grammarAccess.getEnumPropertyAccess().getNameNameKeyword_0_0_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEnumPropertyRule());
                    							}
                    							setWithLastConsumed(current, "name", lv_name_0_0, "name");
                    						

                    }


                    }

                    otherlv_1=(Token)match(input,14,FOLLOW_4); 

                    					newLeafNode(otherlv_1, grammarAccess.getEnumPropertyAccess().getEqualsSignKeyword_0_0_1());
                    				
                    // InternalRDL.g:2539:5: ( (lv_value_2_0= RULE_STR ) )
                    // InternalRDL.g:2540:6: (lv_value_2_0= RULE_STR )
                    {
                    // InternalRDL.g:2540:6: (lv_value_2_0= RULE_STR )
                    // InternalRDL.g:2541:7: lv_value_2_0= RULE_STR
                    {
                    lv_value_2_0=(Token)match(input,RULE_STR,FOLLOW_10); 

                    							newLeafNode(lv_value_2_0, grammarAccess.getEnumPropertyAccess().getValueSTRTerminalRuleCall_0_0_2_0());
                    						

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
                    break;
                case 2 :
                    // InternalRDL.g:2559:4: ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) )
                    {
                    // InternalRDL.g:2559:4: ( ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) ) )
                    // InternalRDL.g:2560:5: ( (lv_name_3_0= 'desc' ) ) otherlv_4= '=' ( (lv_value_5_0= RULE_STR ) )
                    {
                    // InternalRDL.g:2560:5: ( (lv_name_3_0= 'desc' ) )
                    // InternalRDL.g:2561:6: (lv_name_3_0= 'desc' )
                    {
                    // InternalRDL.g:2561:6: (lv_name_3_0= 'desc' )
                    // InternalRDL.g:2562:7: lv_name_3_0= 'desc'
                    {
                    lv_name_3_0=(Token)match(input,36,FOLLOW_8); 

                    							newLeafNode(lv_name_3_0, grammarAccess.getEnumPropertyAccess().getNameDescKeyword_0_1_0_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEnumPropertyRule());
                    							}
                    							setWithLastConsumed(current, "name", lv_name_3_0, "desc");
                    						

                    }


                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_4); 

                    					newLeafNode(otherlv_4, grammarAccess.getEnumPropertyAccess().getEqualsSignKeyword_0_1_1());
                    				
                    // InternalRDL.g:2578:5: ( (lv_value_5_0= RULE_STR ) )
                    // InternalRDL.g:2579:6: (lv_value_5_0= RULE_STR )
                    {
                    // InternalRDL.g:2579:6: (lv_value_5_0= RULE_STR )
                    // InternalRDL.g:2580:7: lv_value_5_0= RULE_STR
                    {
                    lv_value_5_0=(Token)match(input,RULE_STR,FOLLOW_10); 

                    							newLeafNode(lv_value_5_0, grammarAccess.getEnumPropertyAccess().getValueSTRTerminalRuleCall_0_1_2_0());
                    						

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
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getEnumPropertyAccess().getSemicolonKeyword_1());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "rulePropertyTypeName"
    // InternalRDL.g:2606:1: rulePropertyTypeName returns [Enumerator current=null] : ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) ) ;
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
            // InternalRDL.g:2612:2: ( ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) ) )
            // InternalRDL.g:2613:2: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) )
            {
            // InternalRDL.g:2613:2: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'addrmap' ) | (enumLiteral_4= 'reg' ) | (enumLiteral_5= 'regfile' ) | (enumLiteral_6= 'field' ) | (enumLiteral_7= 'ref' ) )
            int alt43=8;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt43=1;
                }
                break;
            case 38:
                {
                alt43=2;
                }
                break;
            case 39:
                {
                alt43=3;
                }
                break;
            case 40:
                {
                alt43=4;
                }
                break;
            case 41:
                {
                alt43=5;
                }
                break;
            case 42:
                {
                alt43=6;
                }
                break;
            case 43:
                {
                alt43=7;
                }
                break;
            case 44:
                {
                alt43=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalRDL.g:2614:3: (enumLiteral_0= 'string' )
                    {
                    // InternalRDL.g:2614:3: (enumLiteral_0= 'string' )
                    // InternalRDL.g:2615:4: enumLiteral_0= 'string'
                    {
                    enumLiteral_0=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyTypeNameAccess().getSTRINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2622:3: (enumLiteral_1= 'number' )
                    {
                    // InternalRDL.g:2622:3: (enumLiteral_1= 'number' )
                    // InternalRDL.g:2623:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPropertyTypeNameAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2630:3: (enumLiteral_2= 'boolean' )
                    {
                    // InternalRDL.g:2630:3: (enumLiteral_2= 'boolean' )
                    // InternalRDL.g:2631:4: enumLiteral_2= 'boolean'
                    {
                    enumLiteral_2=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getBOOLEANEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPropertyTypeNameAccess().getBOOLEANEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2638:3: (enumLiteral_3= 'addrmap' )
                    {
                    // InternalRDL.g:2638:3: (enumLiteral_3= 'addrmap' )
                    // InternalRDL.g:2639:4: enumLiteral_3= 'addrmap'
                    {
                    enumLiteral_3=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getADDRMAPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPropertyTypeNameAccess().getADDRMAPEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2646:3: (enumLiteral_4= 'reg' )
                    {
                    // InternalRDL.g:2646:3: (enumLiteral_4= 'reg' )
                    // InternalRDL.g:2647:4: enumLiteral_4= 'reg'
                    {
                    enumLiteral_4=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getREGEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getPropertyTypeNameAccess().getREGEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:2654:3: (enumLiteral_5= 'regfile' )
                    {
                    // InternalRDL.g:2654:3: (enumLiteral_5= 'regfile' )
                    // InternalRDL.g:2655:4: enumLiteral_5= 'regfile'
                    {
                    enumLiteral_5=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getREGFILEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getPropertyTypeNameAccess().getREGFILEEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRDL.g:2662:3: (enumLiteral_6= 'field' )
                    {
                    // InternalRDL.g:2662:3: (enumLiteral_6= 'field' )
                    // InternalRDL.g:2663:4: enumLiteral_6= 'field'
                    {
                    enumLiteral_6=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getFIELDEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getPropertyTypeNameAccess().getFIELDEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRDL.g:2670:3: (enumLiteral_7= 'ref' )
                    {
                    // InternalRDL.g:2670:3: (enumLiteral_7= 'ref' )
                    // InternalRDL.g:2671:4: enumLiteral_7= 'ref'
                    {
                    enumLiteral_7=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getPropertyTypeNameAccess().getREFEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getPropertyTypeNameAccess().getREFEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2681:1: rulePropertyComponent returns [Enumerator current=null] : ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) ) ;
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
            // InternalRDL.g:2687:2: ( ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) ) )
            // InternalRDL.g:2688:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) )
            {
            // InternalRDL.g:2688:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'reg' ) | (enumLiteral_3= 'regfile' ) | (enumLiteral_4= 'field' ) | (enumLiteral_5= 'all' ) )
            int alt44=6;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt44=1;
                }
                break;
            case 40:
                {
                alt44=2;
                }
                break;
            case 41:
                {
                alt44=3;
                }
                break;
            case 42:
                {
                alt44=4;
                }
                break;
            case 43:
                {
                alt44=5;
                }
                break;
            case 46:
                {
                alt44=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalRDL.g:2689:3: (enumLiteral_0= 'signal' )
                    {
                    // InternalRDL.g:2689:3: (enumLiteral_0= 'signal' )
                    // InternalRDL.g:2690:4: enumLiteral_0= 'signal'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getPropertyComponentAccess().getSIGNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyComponentAccess().getSIGNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2697:3: (enumLiteral_1= 'addrmap' )
                    {
                    // InternalRDL.g:2697:3: (enumLiteral_1= 'addrmap' )
                    // InternalRDL.g:2698:4: enumLiteral_1= 'addrmap'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getPropertyComponentAccess().getADDRMAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPropertyComponentAccess().getADDRMAPEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2705:3: (enumLiteral_2= 'reg' )
                    {
                    // InternalRDL.g:2705:3: (enumLiteral_2= 'reg' )
                    // InternalRDL.g:2706:4: enumLiteral_2= 'reg'
                    {
                    enumLiteral_2=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getPropertyComponentAccess().getREGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPropertyComponentAccess().getREGEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2713:3: (enumLiteral_3= 'regfile' )
                    {
                    // InternalRDL.g:2713:3: (enumLiteral_3= 'regfile' )
                    // InternalRDL.g:2714:4: enumLiteral_3= 'regfile'
                    {
                    enumLiteral_3=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getPropertyComponentAccess().getREGFILEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPropertyComponentAccess().getREGFILEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2721:3: (enumLiteral_4= 'field' )
                    {
                    // InternalRDL.g:2721:3: (enumLiteral_4= 'field' )
                    // InternalRDL.g:2722:4: enumLiteral_4= 'field'
                    {
                    enumLiteral_4=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getPropertyComponentAccess().getFIELDEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getPropertyComponentAccess().getFIELDEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:2729:3: (enumLiteral_5= 'all' )
                    {
                    // InternalRDL.g:2729:3: (enumLiteral_5= 'all' )
                    // InternalRDL.g:2730:4: enumLiteral_5= 'all'
                    {
                    enumLiteral_5=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getPropertyComponentAccess().getALLEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getPropertyComponentAccess().getALLEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2740:1: ruleComponentDefinitionType returns [Enumerator current=null] : ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) ) ;
    public final Enumerator ruleComponentDefinitionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalRDL.g:2746:2: ( ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) ) )
            // InternalRDL.g:2747:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) )
            {
            // InternalRDL.g:2747:2: ( (enumLiteral_0= 'signal' ) | (enumLiteral_1= 'addrmap' ) | (enumLiteral_2= 'regfile' ) | (enumLiteral_3= 'reg' ) | (enumLiteral_4= 'field' ) )
            int alt45=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt45=1;
                }
                break;
            case 40:
                {
                alt45=2;
                }
                break;
            case 42:
                {
                alt45=3;
                }
                break;
            case 41:
                {
                alt45=4;
                }
                break;
            case 43:
                {
                alt45=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalRDL.g:2748:3: (enumLiteral_0= 'signal' )
                    {
                    // InternalRDL.g:2748:3: (enumLiteral_0= 'signal' )
                    // InternalRDL.g:2749:4: enumLiteral_0= 'signal'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getComponentDefinitionTypeAccess().getSIGNALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComponentDefinitionTypeAccess().getSIGNALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2756:3: (enumLiteral_1= 'addrmap' )
                    {
                    // InternalRDL.g:2756:3: (enumLiteral_1= 'addrmap' )
                    // InternalRDL.g:2757:4: enumLiteral_1= 'addrmap'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getComponentDefinitionTypeAccess().getADDRMAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComponentDefinitionTypeAccess().getADDRMAPEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2764:3: (enumLiteral_2= 'regfile' )
                    {
                    // InternalRDL.g:2764:3: (enumLiteral_2= 'regfile' )
                    // InternalRDL.g:2765:4: enumLiteral_2= 'regfile'
                    {
                    enumLiteral_2=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getComponentDefinitionTypeAccess().getREGFILEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComponentDefinitionTypeAccess().getREGFILEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2772:3: (enumLiteral_3= 'reg' )
                    {
                    // InternalRDL.g:2772:3: (enumLiteral_3= 'reg' )
                    // InternalRDL.g:2773:4: enumLiteral_3= 'reg'
                    {
                    enumLiteral_3=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getComponentDefinitionTypeAccess().getREGEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComponentDefinitionTypeAccess().getREGEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2780:3: (enumLiteral_4= 'field' )
                    {
                    // InternalRDL.g:2780:3: (enumLiteral_4= 'field' )
                    // InternalRDL.g:2781:4: enumLiteral_4= 'field'
                    {
                    enumLiteral_4=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getComponentDefinitionTypeAccess().getFIELDEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComponentDefinitionTypeAccess().getFIELDEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:2791:1: ruleProperty returns [Enumerator current=null] : ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) ) ;
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
            // InternalRDL.g:2797:2: ( ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) ) )
            // InternalRDL.g:2798:2: ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) )
            {
            // InternalRDL.g:2798:2: ( (enumLiteral_0= 'name' ) | (enumLiteral_1= 'desc' ) | (enumLiteral_2= 'arbiter' ) | (enumLiteral_3= 'rset' ) | (enumLiteral_4= 'rclr' ) | (enumLiteral_5= 'woclr' ) | (enumLiteral_6= 'woset' ) | (enumLiteral_7= 'we' ) | (enumLiteral_8= 'wel' ) | (enumLiteral_9= 'swwe' ) | (enumLiteral_10= 'swwel' ) | (enumLiteral_11= 'hwset' ) | (enumLiteral_12= 'hwclr' ) | (enumLiteral_13= 'swmod' ) | (enumLiteral_14= 'swacc' ) | (enumLiteral_15= 'sticky' ) | (enumLiteral_16= 'stickybit' ) | (enumLiteral_17= 'intr' ) | (enumLiteral_18= 'anded' ) | (enumLiteral_19= 'ored' ) | (enumLiteral_20= 'xored' ) | (enumLiteral_21= 'counter' ) | (enumLiteral_22= 'overflow' ) | (enumLiteral_23= 'sharedextbus' ) | (enumLiteral_24= 'errextbus' ) | (enumLiteral_25= 'reset' ) | (enumLiteral_26= 'littleendian' ) | (enumLiteral_27= 'bigendian' ) | (enumLiteral_28= 'rsvdset' ) | (enumLiteral_29= 'rsvdsetX' ) | (enumLiteral_30= 'bridge' ) | (enumLiteral_31= 'shared' ) | (enumLiteral_32= 'msb0' ) | (enumLiteral_33= 'lsb0' ) | (enumLiteral_34= 'sync' ) | (enumLiteral_35= 'async' ) | (enumLiteral_36= 'cpuif_reset' ) | (enumLiteral_37= 'field_reset' ) | (enumLiteral_38= 'activehigh' ) | (enumLiteral_39= 'activelow' ) | (enumLiteral_40= 'singlepulse' ) | (enumLiteral_41= 'underflow' ) | (enumLiteral_42= 'incr' ) | (enumLiteral_43= 'decr' ) | (enumLiteral_44= 'incrwidth' ) | (enumLiteral_45= 'decrwidth' ) | (enumLiteral_46= 'incrvalue' ) | (enumLiteral_47= 'decrvalue' ) | (enumLiteral_48= 'saturate' ) | (enumLiteral_49= 'decrsaturate' ) | (enumLiteral_50= 'threshold' ) | (enumLiteral_51= 'decrthreshold' ) | (enumLiteral_52= 'dontcompare' ) | (enumLiteral_53= 'donttest' ) | (enumLiteral_54= 'internal' ) | (enumLiteral_55= 'alignment' ) | (enumLiteral_56= 'regwidth' ) | (enumLiteral_57= 'fieldwidth' ) | (enumLiteral_58= 'signalwidth' ) | (enumLiteral_59= 'accesswidth' ) | (enumLiteral_60= 'sw' ) | (enumLiteral_61= 'hw' ) | (enumLiteral_62= 'addressing' ) | (enumLiteral_63= 'precedence' ) | (enumLiteral_64= 'encode' ) | (enumLiteral_65= 'resetsignal' ) | (enumLiteral_66= 'clock' ) | (enumLiteral_67= 'mask' ) | (enumLiteral_68= 'enable' ) | (enumLiteral_69= 'hwenable' ) | (enumLiteral_70= 'hwmask' ) | (enumLiteral_71= 'haltmask' ) | (enumLiteral_72= 'haltenable' ) | (enumLiteral_73= 'halt' ) | (enumLiteral_74= 'next' ) )
            int alt46=75;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt46=1;
                }
                break;
            case 36:
                {
                alt46=2;
                }
                break;
            case 47:
                {
                alt46=3;
                }
                break;
            case 48:
                {
                alt46=4;
                }
                break;
            case 49:
                {
                alt46=5;
                }
                break;
            case 50:
                {
                alt46=6;
                }
                break;
            case 51:
                {
                alt46=7;
                }
                break;
            case 52:
                {
                alt46=8;
                }
                break;
            case 53:
                {
                alt46=9;
                }
                break;
            case 54:
                {
                alt46=10;
                }
                break;
            case 55:
                {
                alt46=11;
                }
                break;
            case 56:
                {
                alt46=12;
                }
                break;
            case 57:
                {
                alt46=13;
                }
                break;
            case 58:
                {
                alt46=14;
                }
                break;
            case 59:
                {
                alt46=15;
                }
                break;
            case 60:
                {
                alt46=16;
                }
                break;
            case 61:
                {
                alt46=17;
                }
                break;
            case 62:
                {
                alt46=18;
                }
                break;
            case 63:
                {
                alt46=19;
                }
                break;
            case 64:
                {
                alt46=20;
                }
                break;
            case 65:
                {
                alt46=21;
                }
                break;
            case 66:
                {
                alt46=22;
                }
                break;
            case 67:
                {
                alt46=23;
                }
                break;
            case 68:
                {
                alt46=24;
                }
                break;
            case 69:
                {
                alt46=25;
                }
                break;
            case 70:
                {
                alt46=26;
                }
                break;
            case 71:
                {
                alt46=27;
                }
                break;
            case 72:
                {
                alt46=28;
                }
                break;
            case 73:
                {
                alt46=29;
                }
                break;
            case 74:
                {
                alt46=30;
                }
                break;
            case 75:
                {
                alt46=31;
                }
                break;
            case 76:
                {
                alt46=32;
                }
                break;
            case 77:
                {
                alt46=33;
                }
                break;
            case 78:
                {
                alt46=34;
                }
                break;
            case 79:
                {
                alt46=35;
                }
                break;
            case 80:
                {
                alt46=36;
                }
                break;
            case 81:
                {
                alt46=37;
                }
                break;
            case 82:
                {
                alt46=38;
                }
                break;
            case 83:
                {
                alt46=39;
                }
                break;
            case 84:
                {
                alt46=40;
                }
                break;
            case 85:
                {
                alt46=41;
                }
                break;
            case 86:
                {
                alt46=42;
                }
                break;
            case 87:
                {
                alt46=43;
                }
                break;
            case 88:
                {
                alt46=44;
                }
                break;
            case 89:
                {
                alt46=45;
                }
                break;
            case 90:
                {
                alt46=46;
                }
                break;
            case 91:
                {
                alt46=47;
                }
                break;
            case 92:
                {
                alt46=48;
                }
                break;
            case 93:
                {
                alt46=49;
                }
                break;
            case 94:
                {
                alt46=50;
                }
                break;
            case 95:
                {
                alt46=51;
                }
                break;
            case 96:
                {
                alt46=52;
                }
                break;
            case 97:
                {
                alt46=53;
                }
                break;
            case 98:
                {
                alt46=54;
                }
                break;
            case 23:
                {
                alt46=55;
                }
                break;
            case 99:
                {
                alt46=56;
                }
                break;
            case 100:
                {
                alt46=57;
                }
                break;
            case 101:
                {
                alt46=58;
                }
                break;
            case 102:
                {
                alt46=59;
                }
                break;
            case 103:
                {
                alt46=60;
                }
                break;
            case 104:
                {
                alt46=61;
                }
                break;
            case 105:
                {
                alt46=62;
                }
                break;
            case 106:
                {
                alt46=63;
                }
                break;
            case 107:
                {
                alt46=64;
                }
                break;
            case 108:
                {
                alt46=65;
                }
                break;
            case 109:
                {
                alt46=66;
                }
                break;
            case 110:
                {
                alt46=67;
                }
                break;
            case 111:
                {
                alt46=68;
                }
                break;
            case 112:
                {
                alt46=69;
                }
                break;
            case 113:
                {
                alt46=70;
                }
                break;
            case 114:
                {
                alt46=71;
                }
                break;
            case 115:
                {
                alt46=72;
                }
                break;
            case 116:
                {
                alt46=73;
                }
                break;
            case 117:
                {
                alt46=74;
                }
                break;
            case 118:
                {
                alt46=75;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalRDL.g:2799:3: (enumLiteral_0= 'name' )
                    {
                    // InternalRDL.g:2799:3: (enumLiteral_0= 'name' )
                    // InternalRDL.g:2800:4: enumLiteral_0= 'name'
                    {
                    enumLiteral_0=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getNAMEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyAccess().getNAMEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:2807:3: (enumLiteral_1= 'desc' )
                    {
                    // InternalRDL.g:2807:3: (enumLiteral_1= 'desc' )
                    // InternalRDL.g:2808:4: enumLiteral_1= 'desc'
                    {
                    enumLiteral_1=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDESCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPropertyAccess().getDESCEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:2815:3: (enumLiteral_2= 'arbiter' )
                    {
                    // InternalRDL.g:2815:3: (enumLiteral_2= 'arbiter' )
                    // InternalRDL.g:2816:4: enumLiteral_2= 'arbiter'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getARBITEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPropertyAccess().getARBITEREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:2823:3: (enumLiteral_3= 'rset' )
                    {
                    // InternalRDL.g:2823:3: (enumLiteral_3= 'rset' )
                    // InternalRDL.g:2824:4: enumLiteral_3= 'rset'
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getRSETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPropertyAccess().getRSETEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:2831:3: (enumLiteral_4= 'rclr' )
                    {
                    // InternalRDL.g:2831:3: (enumLiteral_4= 'rclr' )
                    // InternalRDL.g:2832:4: enumLiteral_4= 'rclr'
                    {
                    enumLiteral_4=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getRCLREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getPropertyAccess().getRCLREnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:2839:3: (enumLiteral_5= 'woclr' )
                    {
                    // InternalRDL.g:2839:3: (enumLiteral_5= 'woclr' )
                    // InternalRDL.g:2840:4: enumLiteral_5= 'woclr'
                    {
                    enumLiteral_5=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getWOCLREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getPropertyAccess().getWOCLREnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRDL.g:2847:3: (enumLiteral_6= 'woset' )
                    {
                    // InternalRDL.g:2847:3: (enumLiteral_6= 'woset' )
                    // InternalRDL.g:2848:4: enumLiteral_6= 'woset'
                    {
                    enumLiteral_6=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getWOSETEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getPropertyAccess().getWOSETEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRDL.g:2855:3: (enumLiteral_7= 'we' )
                    {
                    // InternalRDL.g:2855:3: (enumLiteral_7= 'we' )
                    // InternalRDL.g:2856:4: enumLiteral_7= 'we'
                    {
                    enumLiteral_7=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getWEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getPropertyAccess().getWEEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalRDL.g:2863:3: (enumLiteral_8= 'wel' )
                    {
                    // InternalRDL.g:2863:3: (enumLiteral_8= 'wel' )
                    // InternalRDL.g:2864:4: enumLiteral_8= 'wel'
                    {
                    enumLiteral_8=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getWELEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getPropertyAccess().getWELEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalRDL.g:2871:3: (enumLiteral_9= 'swwe' )
                    {
                    // InternalRDL.g:2871:3: (enumLiteral_9= 'swwe' )
                    // InternalRDL.g:2872:4: enumLiteral_9= 'swwe'
                    {
                    enumLiteral_9=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSWWEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getPropertyAccess().getSWWEEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalRDL.g:2879:3: (enumLiteral_10= 'swwel' )
                    {
                    // InternalRDL.g:2879:3: (enumLiteral_10= 'swwel' )
                    // InternalRDL.g:2880:4: enumLiteral_10= 'swwel'
                    {
                    enumLiteral_10=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSWWELEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getPropertyAccess().getSWWELEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalRDL.g:2887:3: (enumLiteral_11= 'hwset' )
                    {
                    // InternalRDL.g:2887:3: (enumLiteral_11= 'hwset' )
                    // InternalRDL.g:2888:4: enumLiteral_11= 'hwset'
                    {
                    enumLiteral_11=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHWSETEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getPropertyAccess().getHWSETEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalRDL.g:2895:3: (enumLiteral_12= 'hwclr' )
                    {
                    // InternalRDL.g:2895:3: (enumLiteral_12= 'hwclr' )
                    // InternalRDL.g:2896:4: enumLiteral_12= 'hwclr'
                    {
                    enumLiteral_12=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHWCLREnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getPropertyAccess().getHWCLREnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalRDL.g:2903:3: (enumLiteral_13= 'swmod' )
                    {
                    // InternalRDL.g:2903:3: (enumLiteral_13= 'swmod' )
                    // InternalRDL.g:2904:4: enumLiteral_13= 'swmod'
                    {
                    enumLiteral_13=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSWMODEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getPropertyAccess().getSWMODEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalRDL.g:2911:3: (enumLiteral_14= 'swacc' )
                    {
                    // InternalRDL.g:2911:3: (enumLiteral_14= 'swacc' )
                    // InternalRDL.g:2912:4: enumLiteral_14= 'swacc'
                    {
                    enumLiteral_14=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSWACCEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getPropertyAccess().getSWACCEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalRDL.g:2919:3: (enumLiteral_15= 'sticky' )
                    {
                    // InternalRDL.g:2919:3: (enumLiteral_15= 'sticky' )
                    // InternalRDL.g:2920:4: enumLiteral_15= 'sticky'
                    {
                    enumLiteral_15=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSTICKYEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getPropertyAccess().getSTICKYEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalRDL.g:2927:3: (enumLiteral_16= 'stickybit' )
                    {
                    // InternalRDL.g:2927:3: (enumLiteral_16= 'stickybit' )
                    // InternalRDL.g:2928:4: enumLiteral_16= 'stickybit'
                    {
                    enumLiteral_16=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSTICKYBITEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getPropertyAccess().getSTICKYBITEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalRDL.g:2935:3: (enumLiteral_17= 'intr' )
                    {
                    // InternalRDL.g:2935:3: (enumLiteral_17= 'intr' )
                    // InternalRDL.g:2936:4: enumLiteral_17= 'intr'
                    {
                    enumLiteral_17=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getINTREnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getPropertyAccess().getINTREnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalRDL.g:2943:3: (enumLiteral_18= 'anded' )
                    {
                    // InternalRDL.g:2943:3: (enumLiteral_18= 'anded' )
                    // InternalRDL.g:2944:4: enumLiteral_18= 'anded'
                    {
                    enumLiteral_18=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getANDEDEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getPropertyAccess().getANDEDEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalRDL.g:2951:3: (enumLiteral_19= 'ored' )
                    {
                    // InternalRDL.g:2951:3: (enumLiteral_19= 'ored' )
                    // InternalRDL.g:2952:4: enumLiteral_19= 'ored'
                    {
                    enumLiteral_19=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getOREDEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getPropertyAccess().getOREDEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalRDL.g:2959:3: (enumLiteral_20= 'xored' )
                    {
                    // InternalRDL.g:2959:3: (enumLiteral_20= 'xored' )
                    // InternalRDL.g:2960:4: enumLiteral_20= 'xored'
                    {
                    enumLiteral_20=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getXOREDEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getPropertyAccess().getXOREDEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalRDL.g:2967:3: (enumLiteral_21= 'counter' )
                    {
                    // InternalRDL.g:2967:3: (enumLiteral_21= 'counter' )
                    // InternalRDL.g:2968:4: enumLiteral_21= 'counter'
                    {
                    enumLiteral_21=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getCOUNTEREnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getPropertyAccess().getCOUNTEREnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalRDL.g:2975:3: (enumLiteral_22= 'overflow' )
                    {
                    // InternalRDL.g:2975:3: (enumLiteral_22= 'overflow' )
                    // InternalRDL.g:2976:4: enumLiteral_22= 'overflow'
                    {
                    enumLiteral_22=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getOVERFLOWEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getPropertyAccess().getOVERFLOWEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalRDL.g:2983:3: (enumLiteral_23= 'sharedextbus' )
                    {
                    // InternalRDL.g:2983:3: (enumLiteral_23= 'sharedextbus' )
                    // InternalRDL.g:2984:4: enumLiteral_23= 'sharedextbus'
                    {
                    enumLiteral_23=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSHAREDEXTBUSEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getPropertyAccess().getSHAREDEXTBUSEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalRDL.g:2991:3: (enumLiteral_24= 'errextbus' )
                    {
                    // InternalRDL.g:2991:3: (enumLiteral_24= 'errextbus' )
                    // InternalRDL.g:2992:4: enumLiteral_24= 'errextbus'
                    {
                    enumLiteral_24=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getERREXTBUSEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getPropertyAccess().getERREXTBUSEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalRDL.g:2999:3: (enumLiteral_25= 'reset' )
                    {
                    // InternalRDL.g:2999:3: (enumLiteral_25= 'reset' )
                    // InternalRDL.g:3000:4: enumLiteral_25= 'reset'
                    {
                    enumLiteral_25=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getRESETEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getPropertyAccess().getRESETEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalRDL.g:3007:3: (enumLiteral_26= 'littleendian' )
                    {
                    // InternalRDL.g:3007:3: (enumLiteral_26= 'littleendian' )
                    // InternalRDL.g:3008:4: enumLiteral_26= 'littleendian'
                    {
                    enumLiteral_26=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getLITTLEENDIANEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getPropertyAccess().getLITTLEENDIANEnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalRDL.g:3015:3: (enumLiteral_27= 'bigendian' )
                    {
                    // InternalRDL.g:3015:3: (enumLiteral_27= 'bigendian' )
                    // InternalRDL.g:3016:4: enumLiteral_27= 'bigendian'
                    {
                    enumLiteral_27=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getBIGENDIANEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getPropertyAccess().getBIGENDIANEnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalRDL.g:3023:3: (enumLiteral_28= 'rsvdset' )
                    {
                    // InternalRDL.g:3023:3: (enumLiteral_28= 'rsvdset' )
                    // InternalRDL.g:3024:4: enumLiteral_28= 'rsvdset'
                    {
                    enumLiteral_28=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getRSVDSETEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getPropertyAccess().getRSVDSETEnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalRDL.g:3031:3: (enumLiteral_29= 'rsvdsetX' )
                    {
                    // InternalRDL.g:3031:3: (enumLiteral_29= 'rsvdsetX' )
                    // InternalRDL.g:3032:4: enumLiteral_29= 'rsvdsetX'
                    {
                    enumLiteral_29=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getRSVDSETXEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getPropertyAccess().getRSVDSETXEnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalRDL.g:3039:3: (enumLiteral_30= 'bridge' )
                    {
                    // InternalRDL.g:3039:3: (enumLiteral_30= 'bridge' )
                    // InternalRDL.g:3040:4: enumLiteral_30= 'bridge'
                    {
                    enumLiteral_30=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getBRIDGEEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getPropertyAccess().getBRIDGEEnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalRDL.g:3047:3: (enumLiteral_31= 'shared' )
                    {
                    // InternalRDL.g:3047:3: (enumLiteral_31= 'shared' )
                    // InternalRDL.g:3048:4: enumLiteral_31= 'shared'
                    {
                    enumLiteral_31=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSHAREDEnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getPropertyAccess().getSHAREDEnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalRDL.g:3055:3: (enumLiteral_32= 'msb0' )
                    {
                    // InternalRDL.g:3055:3: (enumLiteral_32= 'msb0' )
                    // InternalRDL.g:3056:4: enumLiteral_32= 'msb0'
                    {
                    enumLiteral_32=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getMSB0EnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getPropertyAccess().getMSB0EnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalRDL.g:3063:3: (enumLiteral_33= 'lsb0' )
                    {
                    // InternalRDL.g:3063:3: (enumLiteral_33= 'lsb0' )
                    // InternalRDL.g:3064:4: enumLiteral_33= 'lsb0'
                    {
                    enumLiteral_33=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getLSB0EnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getPropertyAccess().getLSB0EnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalRDL.g:3071:3: (enumLiteral_34= 'sync' )
                    {
                    // InternalRDL.g:3071:3: (enumLiteral_34= 'sync' )
                    // InternalRDL.g:3072:4: enumLiteral_34= 'sync'
                    {
                    enumLiteral_34=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSYNCEnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getPropertyAccess().getSYNCEnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalRDL.g:3079:3: (enumLiteral_35= 'async' )
                    {
                    // InternalRDL.g:3079:3: (enumLiteral_35= 'async' )
                    // InternalRDL.g:3080:4: enumLiteral_35= 'async'
                    {
                    enumLiteral_35=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getASYNCEnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getPropertyAccess().getASYNCEnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalRDL.g:3087:3: (enumLiteral_36= 'cpuif_reset' )
                    {
                    // InternalRDL.g:3087:3: (enumLiteral_36= 'cpuif_reset' )
                    // InternalRDL.g:3088:4: enumLiteral_36= 'cpuif_reset'
                    {
                    enumLiteral_36=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getCPUIF_RESETEnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getPropertyAccess().getCPUIF_RESETEnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalRDL.g:3095:3: (enumLiteral_37= 'field_reset' )
                    {
                    // InternalRDL.g:3095:3: (enumLiteral_37= 'field_reset' )
                    // InternalRDL.g:3096:4: enumLiteral_37= 'field_reset'
                    {
                    enumLiteral_37=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getFIELD_RESETEnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getPropertyAccess().getFIELD_RESETEnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalRDL.g:3103:3: (enumLiteral_38= 'activehigh' )
                    {
                    // InternalRDL.g:3103:3: (enumLiteral_38= 'activehigh' )
                    // InternalRDL.g:3104:4: enumLiteral_38= 'activehigh'
                    {
                    enumLiteral_38=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getACTIVEHIGHEnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getPropertyAccess().getACTIVEHIGHEnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalRDL.g:3111:3: (enumLiteral_39= 'activelow' )
                    {
                    // InternalRDL.g:3111:3: (enumLiteral_39= 'activelow' )
                    // InternalRDL.g:3112:4: enumLiteral_39= 'activelow'
                    {
                    enumLiteral_39=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getACTIVELOWEnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getPropertyAccess().getACTIVELOWEnumLiteralDeclaration_39());
                    			

                    }


                    }
                    break;
                case 41 :
                    // InternalRDL.g:3119:3: (enumLiteral_40= 'singlepulse' )
                    {
                    // InternalRDL.g:3119:3: (enumLiteral_40= 'singlepulse' )
                    // InternalRDL.g:3120:4: enumLiteral_40= 'singlepulse'
                    {
                    enumLiteral_40=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSINGLEPULSEEnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_40, grammarAccess.getPropertyAccess().getSINGLEPULSEEnumLiteralDeclaration_40());
                    			

                    }


                    }
                    break;
                case 42 :
                    // InternalRDL.g:3127:3: (enumLiteral_41= 'underflow' )
                    {
                    // InternalRDL.g:3127:3: (enumLiteral_41= 'underflow' )
                    // InternalRDL.g:3128:4: enumLiteral_41= 'underflow'
                    {
                    enumLiteral_41=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getUNDERFLOWEnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_41, grammarAccess.getPropertyAccess().getUNDERFLOWEnumLiteralDeclaration_41());
                    			

                    }


                    }
                    break;
                case 43 :
                    // InternalRDL.g:3135:3: (enumLiteral_42= 'incr' )
                    {
                    // InternalRDL.g:3135:3: (enumLiteral_42= 'incr' )
                    // InternalRDL.g:3136:4: enumLiteral_42= 'incr'
                    {
                    enumLiteral_42=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getINCREnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_42, grammarAccess.getPropertyAccess().getINCREnumLiteralDeclaration_42());
                    			

                    }


                    }
                    break;
                case 44 :
                    // InternalRDL.g:3143:3: (enumLiteral_43= 'decr' )
                    {
                    // InternalRDL.g:3143:3: (enumLiteral_43= 'decr' )
                    // InternalRDL.g:3144:4: enumLiteral_43= 'decr'
                    {
                    enumLiteral_43=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDECREnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_43, grammarAccess.getPropertyAccess().getDECREnumLiteralDeclaration_43());
                    			

                    }


                    }
                    break;
                case 45 :
                    // InternalRDL.g:3151:3: (enumLiteral_44= 'incrwidth' )
                    {
                    // InternalRDL.g:3151:3: (enumLiteral_44= 'incrwidth' )
                    // InternalRDL.g:3152:4: enumLiteral_44= 'incrwidth'
                    {
                    enumLiteral_44=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getINCRWIDTHEnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_44, grammarAccess.getPropertyAccess().getINCRWIDTHEnumLiteralDeclaration_44());
                    			

                    }


                    }
                    break;
                case 46 :
                    // InternalRDL.g:3159:3: (enumLiteral_45= 'decrwidth' )
                    {
                    // InternalRDL.g:3159:3: (enumLiteral_45= 'decrwidth' )
                    // InternalRDL.g:3160:4: enumLiteral_45= 'decrwidth'
                    {
                    enumLiteral_45=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDECRWIDTHEnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_45, grammarAccess.getPropertyAccess().getDECRWIDTHEnumLiteralDeclaration_45());
                    			

                    }


                    }
                    break;
                case 47 :
                    // InternalRDL.g:3167:3: (enumLiteral_46= 'incrvalue' )
                    {
                    // InternalRDL.g:3167:3: (enumLiteral_46= 'incrvalue' )
                    // InternalRDL.g:3168:4: enumLiteral_46= 'incrvalue'
                    {
                    enumLiteral_46=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getINCRVALUEEnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_46, grammarAccess.getPropertyAccess().getINCRVALUEEnumLiteralDeclaration_46());
                    			

                    }


                    }
                    break;
                case 48 :
                    // InternalRDL.g:3175:3: (enumLiteral_47= 'decrvalue' )
                    {
                    // InternalRDL.g:3175:3: (enumLiteral_47= 'decrvalue' )
                    // InternalRDL.g:3176:4: enumLiteral_47= 'decrvalue'
                    {
                    enumLiteral_47=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDECRVALUEEnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_47, grammarAccess.getPropertyAccess().getDECRVALUEEnumLiteralDeclaration_47());
                    			

                    }


                    }
                    break;
                case 49 :
                    // InternalRDL.g:3183:3: (enumLiteral_48= 'saturate' )
                    {
                    // InternalRDL.g:3183:3: (enumLiteral_48= 'saturate' )
                    // InternalRDL.g:3184:4: enumLiteral_48= 'saturate'
                    {
                    enumLiteral_48=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSATURATEEnumLiteralDeclaration_48().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_48, grammarAccess.getPropertyAccess().getSATURATEEnumLiteralDeclaration_48());
                    			

                    }


                    }
                    break;
                case 50 :
                    // InternalRDL.g:3191:3: (enumLiteral_49= 'decrsaturate' )
                    {
                    // InternalRDL.g:3191:3: (enumLiteral_49= 'decrsaturate' )
                    // InternalRDL.g:3192:4: enumLiteral_49= 'decrsaturate'
                    {
                    enumLiteral_49=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDECRSATURATEEnumLiteralDeclaration_49().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_49, grammarAccess.getPropertyAccess().getDECRSATURATEEnumLiteralDeclaration_49());
                    			

                    }


                    }
                    break;
                case 51 :
                    // InternalRDL.g:3199:3: (enumLiteral_50= 'threshold' )
                    {
                    // InternalRDL.g:3199:3: (enumLiteral_50= 'threshold' )
                    // InternalRDL.g:3200:4: enumLiteral_50= 'threshold'
                    {
                    enumLiteral_50=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getTHRESHOLDEnumLiteralDeclaration_50().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_50, grammarAccess.getPropertyAccess().getTHRESHOLDEnumLiteralDeclaration_50());
                    			

                    }


                    }
                    break;
                case 52 :
                    // InternalRDL.g:3207:3: (enumLiteral_51= 'decrthreshold' )
                    {
                    // InternalRDL.g:3207:3: (enumLiteral_51= 'decrthreshold' )
                    // InternalRDL.g:3208:4: enumLiteral_51= 'decrthreshold'
                    {
                    enumLiteral_51=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDECRTHRESHOLDEnumLiteralDeclaration_51().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_51, grammarAccess.getPropertyAccess().getDECRTHRESHOLDEnumLiteralDeclaration_51());
                    			

                    }


                    }
                    break;
                case 53 :
                    // InternalRDL.g:3215:3: (enumLiteral_52= 'dontcompare' )
                    {
                    // InternalRDL.g:3215:3: (enumLiteral_52= 'dontcompare' )
                    // InternalRDL.g:3216:4: enumLiteral_52= 'dontcompare'
                    {
                    enumLiteral_52=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDONTCOMPAREEnumLiteralDeclaration_52().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_52, grammarAccess.getPropertyAccess().getDONTCOMPAREEnumLiteralDeclaration_52());
                    			

                    }


                    }
                    break;
                case 54 :
                    // InternalRDL.g:3223:3: (enumLiteral_53= 'donttest' )
                    {
                    // InternalRDL.g:3223:3: (enumLiteral_53= 'donttest' )
                    // InternalRDL.g:3224:4: enumLiteral_53= 'donttest'
                    {
                    enumLiteral_53=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getDONTTESTEnumLiteralDeclaration_53().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_53, grammarAccess.getPropertyAccess().getDONTTESTEnumLiteralDeclaration_53());
                    			

                    }


                    }
                    break;
                case 55 :
                    // InternalRDL.g:3231:3: (enumLiteral_54= 'internal' )
                    {
                    // InternalRDL.g:3231:3: (enumLiteral_54= 'internal' )
                    // InternalRDL.g:3232:4: enumLiteral_54= 'internal'
                    {
                    enumLiteral_54=(Token)match(input,23,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getINTERNALEnumLiteralDeclaration_54().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_54, grammarAccess.getPropertyAccess().getINTERNALEnumLiteralDeclaration_54());
                    			

                    }


                    }
                    break;
                case 56 :
                    // InternalRDL.g:3239:3: (enumLiteral_55= 'alignment' )
                    {
                    // InternalRDL.g:3239:3: (enumLiteral_55= 'alignment' )
                    // InternalRDL.g:3240:4: enumLiteral_55= 'alignment'
                    {
                    enumLiteral_55=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getALIGNMENTEnumLiteralDeclaration_55().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_55, grammarAccess.getPropertyAccess().getALIGNMENTEnumLiteralDeclaration_55());
                    			

                    }


                    }
                    break;
                case 57 :
                    // InternalRDL.g:3247:3: (enumLiteral_56= 'regwidth' )
                    {
                    // InternalRDL.g:3247:3: (enumLiteral_56= 'regwidth' )
                    // InternalRDL.g:3248:4: enumLiteral_56= 'regwidth'
                    {
                    enumLiteral_56=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getREGWIDTHEnumLiteralDeclaration_56().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_56, grammarAccess.getPropertyAccess().getREGWIDTHEnumLiteralDeclaration_56());
                    			

                    }


                    }
                    break;
                case 58 :
                    // InternalRDL.g:3255:3: (enumLiteral_57= 'fieldwidth' )
                    {
                    // InternalRDL.g:3255:3: (enumLiteral_57= 'fieldwidth' )
                    // InternalRDL.g:3256:4: enumLiteral_57= 'fieldwidth'
                    {
                    enumLiteral_57=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getFIELDWIDTHEnumLiteralDeclaration_57().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_57, grammarAccess.getPropertyAccess().getFIELDWIDTHEnumLiteralDeclaration_57());
                    			

                    }


                    }
                    break;
                case 59 :
                    // InternalRDL.g:3263:3: (enumLiteral_58= 'signalwidth' )
                    {
                    // InternalRDL.g:3263:3: (enumLiteral_58= 'signalwidth' )
                    // InternalRDL.g:3264:4: enumLiteral_58= 'signalwidth'
                    {
                    enumLiteral_58=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSIGNALWIDTHEnumLiteralDeclaration_58().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_58, grammarAccess.getPropertyAccess().getSIGNALWIDTHEnumLiteralDeclaration_58());
                    			

                    }


                    }
                    break;
                case 60 :
                    // InternalRDL.g:3271:3: (enumLiteral_59= 'accesswidth' )
                    {
                    // InternalRDL.g:3271:3: (enumLiteral_59= 'accesswidth' )
                    // InternalRDL.g:3272:4: enumLiteral_59= 'accesswidth'
                    {
                    enumLiteral_59=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getACCESSWIDTHEnumLiteralDeclaration_59().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_59, grammarAccess.getPropertyAccess().getACCESSWIDTHEnumLiteralDeclaration_59());
                    			

                    }


                    }
                    break;
                case 61 :
                    // InternalRDL.g:3279:3: (enumLiteral_60= 'sw' )
                    {
                    // InternalRDL.g:3279:3: (enumLiteral_60= 'sw' )
                    // InternalRDL.g:3280:4: enumLiteral_60= 'sw'
                    {
                    enumLiteral_60=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getSWEnumLiteralDeclaration_60().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_60, grammarAccess.getPropertyAccess().getSWEnumLiteralDeclaration_60());
                    			

                    }


                    }
                    break;
                case 62 :
                    // InternalRDL.g:3287:3: (enumLiteral_61= 'hw' )
                    {
                    // InternalRDL.g:3287:3: (enumLiteral_61= 'hw' )
                    // InternalRDL.g:3288:4: enumLiteral_61= 'hw'
                    {
                    enumLiteral_61=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHWEnumLiteralDeclaration_61().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_61, grammarAccess.getPropertyAccess().getHWEnumLiteralDeclaration_61());
                    			

                    }


                    }
                    break;
                case 63 :
                    // InternalRDL.g:3295:3: (enumLiteral_62= 'addressing' )
                    {
                    // InternalRDL.g:3295:3: (enumLiteral_62= 'addressing' )
                    // InternalRDL.g:3296:4: enumLiteral_62= 'addressing'
                    {
                    enumLiteral_62=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getADDRESSINGEnumLiteralDeclaration_62().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_62, grammarAccess.getPropertyAccess().getADDRESSINGEnumLiteralDeclaration_62());
                    			

                    }


                    }
                    break;
                case 64 :
                    // InternalRDL.g:3303:3: (enumLiteral_63= 'precedence' )
                    {
                    // InternalRDL.g:3303:3: (enumLiteral_63= 'precedence' )
                    // InternalRDL.g:3304:4: enumLiteral_63= 'precedence'
                    {
                    enumLiteral_63=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getPRECEDENCEEnumLiteralDeclaration_63().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_63, grammarAccess.getPropertyAccess().getPRECEDENCEEnumLiteralDeclaration_63());
                    			

                    }


                    }
                    break;
                case 65 :
                    // InternalRDL.g:3311:3: (enumLiteral_64= 'encode' )
                    {
                    // InternalRDL.g:3311:3: (enumLiteral_64= 'encode' )
                    // InternalRDL.g:3312:4: enumLiteral_64= 'encode'
                    {
                    enumLiteral_64=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getENCODEEnumLiteralDeclaration_64().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_64, grammarAccess.getPropertyAccess().getENCODEEnumLiteralDeclaration_64());
                    			

                    }


                    }
                    break;
                case 66 :
                    // InternalRDL.g:3319:3: (enumLiteral_65= 'resetsignal' )
                    {
                    // InternalRDL.g:3319:3: (enumLiteral_65= 'resetsignal' )
                    // InternalRDL.g:3320:4: enumLiteral_65= 'resetsignal'
                    {
                    enumLiteral_65=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getRESETSIGNALEnumLiteralDeclaration_65().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_65, grammarAccess.getPropertyAccess().getRESETSIGNALEnumLiteralDeclaration_65());
                    			

                    }


                    }
                    break;
                case 67 :
                    // InternalRDL.g:3327:3: (enumLiteral_66= 'clock' )
                    {
                    // InternalRDL.g:3327:3: (enumLiteral_66= 'clock' )
                    // InternalRDL.g:3328:4: enumLiteral_66= 'clock'
                    {
                    enumLiteral_66=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getCLOCKEnumLiteralDeclaration_66().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_66, grammarAccess.getPropertyAccess().getCLOCKEnumLiteralDeclaration_66());
                    			

                    }


                    }
                    break;
                case 68 :
                    // InternalRDL.g:3335:3: (enumLiteral_67= 'mask' )
                    {
                    // InternalRDL.g:3335:3: (enumLiteral_67= 'mask' )
                    // InternalRDL.g:3336:4: enumLiteral_67= 'mask'
                    {
                    enumLiteral_67=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getMASKEnumLiteralDeclaration_67().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_67, grammarAccess.getPropertyAccess().getMASKEnumLiteralDeclaration_67());
                    			

                    }


                    }
                    break;
                case 69 :
                    // InternalRDL.g:3343:3: (enumLiteral_68= 'enable' )
                    {
                    // InternalRDL.g:3343:3: (enumLiteral_68= 'enable' )
                    // InternalRDL.g:3344:4: enumLiteral_68= 'enable'
                    {
                    enumLiteral_68=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getENABLEEnumLiteralDeclaration_68().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_68, grammarAccess.getPropertyAccess().getENABLEEnumLiteralDeclaration_68());
                    			

                    }


                    }
                    break;
                case 70 :
                    // InternalRDL.g:3351:3: (enumLiteral_69= 'hwenable' )
                    {
                    // InternalRDL.g:3351:3: (enumLiteral_69= 'hwenable' )
                    // InternalRDL.g:3352:4: enumLiteral_69= 'hwenable'
                    {
                    enumLiteral_69=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHWENABLEEnumLiteralDeclaration_69().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_69, grammarAccess.getPropertyAccess().getHWENABLEEnumLiteralDeclaration_69());
                    			

                    }


                    }
                    break;
                case 71 :
                    // InternalRDL.g:3359:3: (enumLiteral_70= 'hwmask' )
                    {
                    // InternalRDL.g:3359:3: (enumLiteral_70= 'hwmask' )
                    // InternalRDL.g:3360:4: enumLiteral_70= 'hwmask'
                    {
                    enumLiteral_70=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHWMASKEnumLiteralDeclaration_70().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_70, grammarAccess.getPropertyAccess().getHWMASKEnumLiteralDeclaration_70());
                    			

                    }


                    }
                    break;
                case 72 :
                    // InternalRDL.g:3367:3: (enumLiteral_71= 'haltmask' )
                    {
                    // InternalRDL.g:3367:3: (enumLiteral_71= 'haltmask' )
                    // InternalRDL.g:3368:4: enumLiteral_71= 'haltmask'
                    {
                    enumLiteral_71=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHALTMASKEnumLiteralDeclaration_71().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_71, grammarAccess.getPropertyAccess().getHALTMASKEnumLiteralDeclaration_71());
                    			

                    }


                    }
                    break;
                case 73 :
                    // InternalRDL.g:3375:3: (enumLiteral_72= 'haltenable' )
                    {
                    // InternalRDL.g:3375:3: (enumLiteral_72= 'haltenable' )
                    // InternalRDL.g:3376:4: enumLiteral_72= 'haltenable'
                    {
                    enumLiteral_72=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHALTENABLEEnumLiteralDeclaration_72().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_72, grammarAccess.getPropertyAccess().getHALTENABLEEnumLiteralDeclaration_72());
                    			

                    }


                    }
                    break;
                case 74 :
                    // InternalRDL.g:3383:3: (enumLiteral_73= 'halt' )
                    {
                    // InternalRDL.g:3383:3: (enumLiteral_73= 'halt' )
                    // InternalRDL.g:3384:4: enumLiteral_73= 'halt'
                    {
                    enumLiteral_73=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getHALTEnumLiteralDeclaration_73().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_73, grammarAccess.getPropertyAccess().getHALTEnumLiteralDeclaration_73());
                    			

                    }


                    }
                    break;
                case 75 :
                    // InternalRDL.g:3391:3: (enumLiteral_74= 'next' )
                    {
                    // InternalRDL.g:3391:3: (enumLiteral_74= 'next' )
                    // InternalRDL.g:3392:4: enumLiteral_74= 'next'
                    {
                    enumLiteral_74=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getPropertyAccess().getNEXTEnumLiteralDeclaration_74().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_74, grammarAccess.getPropertyAccess().getNEXTEnumLiteralDeclaration_74());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:3402:1: ruleRValueConstant returns [Enumerator current=null] : ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) ) ;
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
            // InternalRDL.g:3408:2: ( ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) ) )
            // InternalRDL.g:3409:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) )
            {
            // InternalRDL.g:3409:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'true' ) | (enumLiteral_2= 'false' ) | (enumLiteral_3= 'rw' ) | (enumLiteral_4= 'wr' ) | (enumLiteral_5= 'r' ) | (enumLiteral_6= 'w' ) | (enumLiteral_7= 'na' ) | (enumLiteral_8= 'compact' ) | (enumLiteral_9= 'regalign' ) | (enumLiteral_10= 'fullalign' ) | (enumLiteral_11= 'hw' ) | (enumLiteral_12= 'sw' ) )
            int alt47=13;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt47=1;
                }
                break;
            case 18:
                {
                alt47=2;
                }
                break;
            case 19:
                {
                alt47=3;
                }
                break;
            case 120:
                {
                alt47=4;
                }
                break;
            case 121:
                {
                alt47=5;
                }
                break;
            case 122:
                {
                alt47=6;
                }
                break;
            case 123:
                {
                alt47=7;
                }
                break;
            case 124:
                {
                alt47=8;
                }
                break;
            case 125:
                {
                alt47=9;
                }
                break;
            case 126:
                {
                alt47=10;
                }
                break;
            case 127:
                {
                alt47=11;
                }
                break;
            case 105:
                {
                alt47=12;
                }
                break;
            case 104:
                {
                alt47=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalRDL.g:3410:3: (enumLiteral_0= 'UNDEFINED' )
                    {
                    // InternalRDL.g:3410:3: (enumLiteral_0= 'UNDEFINED' )
                    // InternalRDL.g:3411:4: enumLiteral_0= 'UNDEFINED'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getUNDEFINEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRValueConstantAccess().getUNDEFINEDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:3418:3: (enumLiteral_1= 'true' )
                    {
                    // InternalRDL.g:3418:3: (enumLiteral_1= 'true' )
                    // InternalRDL.g:3419:4: enumLiteral_1= 'true'
                    {
                    enumLiteral_1=(Token)match(input,18,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getTRUEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRValueConstantAccess().getTRUEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:3426:3: (enumLiteral_2= 'false' )
                    {
                    // InternalRDL.g:3426:3: (enumLiteral_2= 'false' )
                    // InternalRDL.g:3427:4: enumLiteral_2= 'false'
                    {
                    enumLiteral_2=(Token)match(input,19,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getFALSEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRValueConstantAccess().getFALSEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:3434:3: (enumLiteral_3= 'rw' )
                    {
                    // InternalRDL.g:3434:3: (enumLiteral_3= 'rw' )
                    // InternalRDL.g:3435:4: enumLiteral_3= 'rw'
                    {
                    enumLiteral_3=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getRWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRValueConstantAccess().getRWEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:3442:3: (enumLiteral_4= 'wr' )
                    {
                    // InternalRDL.g:3442:3: (enumLiteral_4= 'wr' )
                    // InternalRDL.g:3443:4: enumLiteral_4= 'wr'
                    {
                    enumLiteral_4=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getWREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRValueConstantAccess().getWREnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:3450:3: (enumLiteral_5= 'r' )
                    {
                    // InternalRDL.g:3450:3: (enumLiteral_5= 'r' )
                    // InternalRDL.g:3451:4: enumLiteral_5= 'r'
                    {
                    enumLiteral_5=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRValueConstantAccess().getREnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRDL.g:3458:3: (enumLiteral_6= 'w' )
                    {
                    // InternalRDL.g:3458:3: (enumLiteral_6= 'w' )
                    // InternalRDL.g:3459:4: enumLiteral_6= 'w'
                    {
                    enumLiteral_6=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getWEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getRValueConstantAccess().getWEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRDL.g:3466:3: (enumLiteral_7= 'na' )
                    {
                    // InternalRDL.g:3466:3: (enumLiteral_7= 'na' )
                    // InternalRDL.g:3467:4: enumLiteral_7= 'na'
                    {
                    enumLiteral_7=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getNAEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getRValueConstantAccess().getNAEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalRDL.g:3474:3: (enumLiteral_8= 'compact' )
                    {
                    // InternalRDL.g:3474:3: (enumLiteral_8= 'compact' )
                    // InternalRDL.g:3475:4: enumLiteral_8= 'compact'
                    {
                    enumLiteral_8=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getCOMPACTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getRValueConstantAccess().getCOMPACTEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalRDL.g:3482:3: (enumLiteral_9= 'regalign' )
                    {
                    // InternalRDL.g:3482:3: (enumLiteral_9= 'regalign' )
                    // InternalRDL.g:3483:4: enumLiteral_9= 'regalign'
                    {
                    enumLiteral_9=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getREGALIGNEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getRValueConstantAccess().getREGALIGNEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalRDL.g:3490:3: (enumLiteral_10= 'fullalign' )
                    {
                    // InternalRDL.g:3490:3: (enumLiteral_10= 'fullalign' )
                    // InternalRDL.g:3491:4: enumLiteral_10= 'fullalign'
                    {
                    enumLiteral_10=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getFULLALIGNEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getRValueConstantAccess().getFULLALIGNEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalRDL.g:3498:3: (enumLiteral_11= 'hw' )
                    {
                    // InternalRDL.g:3498:3: (enumLiteral_11= 'hw' )
                    // InternalRDL.g:3499:4: enumLiteral_11= 'hw'
                    {
                    enumLiteral_11=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getHWEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getRValueConstantAccess().getHWEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalRDL.g:3506:3: (enumLiteral_12= 'sw' )
                    {
                    // InternalRDL.g:3506:3: (enumLiteral_12= 'sw' )
                    // InternalRDL.g:3507:4: enumLiteral_12= 'sw'
                    {
                    enumLiteral_12=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getRValueConstantAccess().getSWEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getRValueConstantAccess().getSWEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRDL.g:3517:1: rulePropertyModifier returns [Enumerator current=null] : ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) ) ;
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
            // InternalRDL.g:3523:2: ( ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) ) )
            // InternalRDL.g:3524:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) )
            {
            // InternalRDL.g:3524:2: ( (enumLiteral_0= 'UNDEFINED' ) | (enumLiteral_1= 'posedge' ) | (enumLiteral_2= 'negedge' ) | (enumLiteral_3= 'bothedge' ) | (enumLiteral_4= 'level' ) | (enumLiteral_5= 'nonsticky' ) )
            int alt48=6;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt48=1;
                }
                break;
            case 128:
                {
                alt48=2;
                }
                break;
            case 129:
                {
                alt48=3;
                }
                break;
            case 130:
                {
                alt48=4;
                }
                break;
            case 131:
                {
                alt48=5;
                }
                break;
            case 132:
                {
                alt48=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalRDL.g:3525:3: (enumLiteral_0= 'UNDEFINED' )
                    {
                    // InternalRDL.g:3525:3: (enumLiteral_0= 'UNDEFINED' )
                    // InternalRDL.g:3526:4: enumLiteral_0= 'UNDEFINED'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getPropertyModifierAccess().getUNDEFINEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPropertyModifierAccess().getUNDEFINEDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRDL.g:3533:3: (enumLiteral_1= 'posedge' )
                    {
                    // InternalRDL.g:3533:3: (enumLiteral_1= 'posedge' )
                    // InternalRDL.g:3534:4: enumLiteral_1= 'posedge'
                    {
                    enumLiteral_1=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getPropertyModifierAccess().getPOSEDGEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPropertyModifierAccess().getPOSEDGEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRDL.g:3541:3: (enumLiteral_2= 'negedge' )
                    {
                    // InternalRDL.g:3541:3: (enumLiteral_2= 'negedge' )
                    // InternalRDL.g:3542:4: enumLiteral_2= 'negedge'
                    {
                    enumLiteral_2=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getPropertyModifierAccess().getNEGEDGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPropertyModifierAccess().getNEGEDGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRDL.g:3549:3: (enumLiteral_3= 'bothedge' )
                    {
                    // InternalRDL.g:3549:3: (enumLiteral_3= 'bothedge' )
                    // InternalRDL.g:3550:4: enumLiteral_3= 'bothedge'
                    {
                    enumLiteral_3=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getPropertyModifierAccess().getBOTHEDGEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPropertyModifierAccess().getBOTHEDGEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRDL.g:3557:3: (enumLiteral_4= 'level' )
                    {
                    // InternalRDL.g:3557:3: (enumLiteral_4= 'level' )
                    // InternalRDL.g:3558:4: enumLiteral_4= 'level'
                    {
                    enumLiteral_4=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getPropertyModifierAccess().getLEVELEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getPropertyModifierAccess().getLEVELEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRDL.g:3565:3: (enumLiteral_5= 'nonsticky' )
                    {
                    // InternalRDL.g:3565:3: (enumLiteral_5= 'nonsticky' )
                    // InternalRDL.g:3566:4: enumLiteral_5= 'nonsticky'
                    {
                    enumLiteral_5=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getPropertyModifierAccess().getNONSTICKYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getPropertyModifierAccess().getNONSTICKYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

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

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\1\11\uffff";
    static final String dfa_3s = "\1\5\5\uffff\2\5\2\uffff";
    static final String dfa_4s = "\1\u0084\5\uffff\1\30\1\41\2\uffff";
    static final String dfa_5s = "\1\uffff\1\7\1\1\1\2\1\3\1\4\2\uffff\1\5\1\6";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\7\4\uffff\1\2\1\11\5\uffff\1\10\4\uffff\1\5\1\6\1\5\11\uffff\1\4\2\10\3\uffff\4\3\1\uffff\1\3\1\uffff\111\10\10\uffff\5\10",
            "",
            "",
            "",
            "",
            "",
            "\1\5\10\uffff\2\10\10\uffff\1\5",
            "\1\5\10\uffff\2\10\20\uffff\2\10",
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
            return "()* loopback of 79:2: ( ( (lv_includes_0_0= ruleInclude ) ) | ( (lv_componentDefinitions_1_0= ruleComponentDefinition ) ) | ( (lv_enumDefinitions_2_0= ruleEnumDefinition ) ) | ( (lv_namedInstantiations_3_0= ruleNamedInstantiation ) ) | ( (lv_propertyAssignments_4_0= rulePropertyAssignment ) ) | ( (lv_propertyDefinitions_5_0= rulePropertyDefinition ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xFFFFAF1C01C20C22L,0x00FFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000122000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00001FE000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000132000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000000C0050L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00006F0000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xFFFFAF1C01C30020L,0x00FFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000408020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001800020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000003C004002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000001C004002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0xFFFF801800800000L,0x00FFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000000000C1070L,0xFF80030000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xFFFF801800800020L,0x00FFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000001800010000L});

}