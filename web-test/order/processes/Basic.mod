[Ivy]
16FF0CCD2C4FE02D 7.5.0 #module
>Proto >Proto Collection #zClass
Bc0 Basic Big #zClass
Bc0 B #cInfo
Bc0 #process
Bc0 @TextInP .type .type #zField
Bc0 @TextInP .processKind .processKind #zField
Bc0 @TextInP .xml .xml #zField
Bc0 @TextInP .responsibility .responsibility #zField
Bc0 @StartRequest f0 '' #zField
Bc0 @EndTask f1 '' #zField
Bc0 @UserDialog f3 '' #zField
Bc0 @PushWFArc f4 '' #zField
Bc0 @UserDialog f5 '' #zField
Bc0 @PushWFArc f6 '' #zField
Bc0 @PushWFArc f2 '' #zField
>Proto Bc0 Bc0 Basic #zField
Bc0 f0 outLink start.ivp #txt
Bc0 f0 inParamDecl '<> param;' #txt
Bc0 f0 requestEnabled true #txt
Bc0 f0 triggerEnabled false #txt
Bc0 f0 callSignature start() #txt
Bc0 f0 caseData businessCase.attach=true #txt
Bc0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
Bc0 f0 @C|.responsibility Everybody #txt
Bc0 f0 81 49 30 30 -25 17 #rect
Bc0 f0 @|StartRequestIcon #fIcon
Bc0 f1 497 49 30 30 0 15 #rect
Bc0 f1 @|EndIcon #fIcon
Bc0 f3 dialogId ch.ivyteam.ivy.project.demo.ci.order.SimpleInputForm #txt
Bc0 f3 startMethod start() #txt
Bc0 f3 requestActionDecl '<> param;' #txt
Bc0 f3 responseMappingAction 'out=in;
out.input=result.input;
' #txt
Bc0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>SimpleInputForm</name>
    </language>
</elementInfo>
' #txt
Bc0 f3 168 42 112 44 -52 -7 #rect
Bc0 f3 @|UserDialogIcon #fIcon
Bc0 f4 111 64 168 64 #arcP
Bc0 f5 dialogId ch.ivyteam.ivy.project.demo.ci.order.ValidateSimpleInput #txt
Bc0 f5 startMethod start(String) #txt
Bc0 f5 requestActionDecl '<String input> param;' #txt
Bc0 f5 requestMappingAction 'param.input=in.input;
' #txt
Bc0 f5 responseMappingAction 'out=in;
' #txt
Bc0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>ValidateSimpleInput</name>
    </language>
</elementInfo>
' #txt
Bc0 f5 320 42 128 44 -61 -7 #rect
Bc0 f5 @|UserDialogIcon #fIcon
Bc0 f6 280 64 320 64 #arcP
Bc0 f2 448 64 497 64 #arcP
>Proto Bc0 .type ch.ivyteam.ivy.project.demo.ci.order.Data #txt
>Proto Bc0 .processKind NORMAL #txt
>Proto Bc0 0 0 32 24 18 0 #rect
>Proto Bc0 @|BIcon #fIcon
Bc0 f0 mainOut f4 tail #connect
Bc0 f4 head f3 mainIn #connect
Bc0 f3 mainOut f6 tail #connect
Bc0 f6 head f5 mainIn #connect
Bc0 f5 mainOut f2 tail #connect
Bc0 f2 head f1 mainIn #connect
