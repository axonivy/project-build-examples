[Ivy]
15F259DEAC8FEB83 9.3.1 #module
>Proto >Proto Collection #zClass
Me0 Manage Big #zClass
Me0 B #cInfo
Me0 #process
Me0 @TextInP .type .type #zField
Me0 @TextInP .processKind .processKind #zField
Me0 @AnnotationInP-0n ai ai #zField
Me0 @MessageFlowInP-0n messageIn messageIn #zField
Me0 @MessageFlowOutP-0n messageOut messageOut #zField
Me0 @TextInP .xml .xml #zField
Me0 @TextInP .responsibility .responsibility #zField
Me0 @StartRequest f0 '' #zField
Me0 @EndTask f1 '' #zField
Me0 @UserDialog f3 '' #zField
Me0 @PushWFArc f4 '' #zField
Me0 @GridStep f5 '' #zField
Me0 @PushWFArc f6 '' #zField
Me0 @PushWFArc f2 '' #zField
>Proto Me0 Me0 Manage #zField
Me0 f0 outLink start.ivp #txt
Me0 f0 inParamDecl '<> param;' #txt
Me0 f0 requestEnabled true #txt
Me0 f0 triggerEnabled false #txt
Me0 f0 callSignature start() #txt
Me0 f0 caseData businessCase.attach=true #txt
Me0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
Me0 f0 @C|.responsibility Everybody #txt
Me0 f0 81 49 30 30 -25 17 #rect
Me0 f1 497 49 30 30 0 15 #rect
Me0 f3 dialogId ci.deploy.solution.UserManager #txt
Me0 f3 startMethod start() #txt
Me0 f3 requestActionDecl '<> param;' #txt
Me0 f3 responseActionDecl 'ci.deploy.customer.Data out;
' #txt
Me0 f3 responseMappingAction 'out=in;
' #txt
Me0 f3 168 42 112 44 0 -7 #rect
Me0 f4 expr out #txt
Me0 f4 111 64 168 64 #arcP
Me0 f5 actionTable 'out=in;
' #txt
Me0 f5 actionCode 'import ci.deploy.base.User;
ivy.log.info(ivy.persistence.users.findAll(User.Class));' #txt
Me0 f5 security system #txt
Me0 f5 328 42 112 44 0 -7 #rect
Me0 f6 expr out #txt
Me0 f6 280 64 328 64 #arcP
Me0 f2 expr out #txt
Me0 f2 440 64 497 64 #arcP
>Proto Me0 .type ci.deploy.customer.Data #txt
>Proto Me0 .processKind NORMAL #txt
>Proto Me0 0 0 32 24 18 0 #rect
>Proto Me0 @|BIcon #fIcon
Me0 f0 mainOut f4 tail #connect
Me0 f4 head f3 mainIn #connect
Me0 f3 mainOut f6 tail #connect
Me0 f6 head f5 mainIn #connect
Me0 f5 mainOut f2 tail #connect
Me0 f2 head f1 mainIn #connect
