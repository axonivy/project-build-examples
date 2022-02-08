[Ivy]
15287EC41B05C6C5 9.3.1 #module
>Proto >Proto Collection #zClass
cr0 customer Big #zClass
cr0 B #cInfo
cr0 #process
cr0 @TextInP .type .type #zField
cr0 @TextInP .processKind .processKind #zField
cr0 @AnnotationInP-0n ai ai #zField
cr0 @MessageFlowInP-0n messageIn messageIn #zField
cr0 @MessageFlowOutP-0n messageOut messageOut #zField
cr0 @TextInP .xml .xml #zField
cr0 @TextInP .responsibility .responsibility #zField
cr0 @StartRequest f0 '' #zField
cr0 @EndTask f1 '' #zField
cr0 @UserDialog f3 '' #zField
cr0 @PushWFArc f4 '' #zField
cr0 @UserDialog f5 '' #zField
cr0 @PushWFArc f6 '' #zField
cr0 @PushWFArc f2 '' #zField
>Proto cr0 cr0 customer #zField
cr0 f0 outLink register.ivp #txt
cr0 f0 inParamDecl '<> param;' #txt
cr0 f0 requestEnabled true #txt
cr0 f0 triggerEnabled false #txt
cr0 f0 callSignature register() #txt
cr0 f0 persist false #txt
cr0 f0 taskData 'TaskTriggered.EXPRI=2
TaskTriggered.EXROL=Everybody
TaskTriggered.EXTYPE=0
TaskTriggered.PRI=2
TaskTriggered.ROL=Everybody
TaskTriggered.TYPE=0' #txt
cr0 f0 showInStartList 1 #txt
cr0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>register.ivp</name>
    </language>
</elementInfo>
' #txt
cr0 f0 @C|.responsibility Everybody #txt
cr0 f0 81 49 30 30 -30 17 #rect
cr0 f1 513 49 30 30 0 15 #rect
cr0 f3 dialogId crm.CustomerRegistrationForm #txt
cr0 f3 startMethod start() #txt
cr0 f3 requestActionDecl '<> param;' #txt
cr0 f3 responseActionDecl 'crm.Data out;
' #txt
cr0 f3 responseMappingAction 'out=in;
out.newCustomer=result.customer;
' #txt
cr0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>register new
customer</name>
        <nameStyle>13,7
8,7
</nameStyle>
    </language>
</elementInfo>
' #txt
cr0 f3 168 42 112 44 -34 -16 #rect
cr0 f4 expr out #txt
cr0 f4 111 64 168 64 #arcP
cr0 f5 dialogId crm.WelcomeNewCustomer #txt
cr0 f5 startMethod start(crm.Customer) #txt
cr0 f5 requestActionDecl '<crm.Customer newCustomer> param;' #txt
cr0 f5 requestMappingAction 'param.newCustomer=in.newCustomer;
' #txt
cr0 f5 responseMappingAction 'out=in;
' #txt
cr0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>welcome new customer</name>
    </language>
</elementInfo>
' #txt
cr0 f5 312 42 160 44 -73 -7 #rect
cr0 f6 expr out #txt
cr0 f6 280 64 312 64 #arcP
cr0 f2 472 64 513 64 #arcP
>Proto cr0 .type crm.Data #txt
>Proto cr0 .processKind NORMAL #txt
>Proto cr0 0 0 32 24 18 0 #rect
>Proto cr0 @|BIcon #fIcon
cr0 f0 mainOut f4 tail #connect
cr0 f4 head f3 mainIn #connect
cr0 f3 mainOut f6 tail #connect
cr0 f6 head f5 mainIn #connect
cr0 f5 mainOut f2 tail #connect
cr0 f2 head f1 mainIn #connect
