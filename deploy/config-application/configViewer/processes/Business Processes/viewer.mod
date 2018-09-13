[Ivy]
165D1DB99A4DEBE0 3.23 #module
>Proto >Proto Collection #zClass
vr0 viewer Big #zClass
vr0 B #cInfo
vr0 #process
vr0 @TextInP .resExport .resExport #zField
vr0 @TextInP .type .type #zField
vr0 @TextInP .processKind .processKind #zField
vr0 @AnnotationInP-0n ai ai #zField
vr0 @MessageFlowInP-0n messageIn messageIn #zField
vr0 @MessageFlowOutP-0n messageOut messageOut #zField
vr0 @TextInP .xml .xml #zField
vr0 @TextInP .responsibility .responsibility #zField
vr0 @StartRequest f0 '' #zField
vr0 @EndTask f1 '' #zField
vr0 @RichDialog f3 '' #zField
vr0 @PushWFArc f4 '' #zField
vr0 @PushWFArc f2 '' #zField
>Proto vr0 vr0 viewer #zField
vr0 f0 outLink start.ivp #txt
vr0 f0 type app.config.viewer.Data #txt
vr0 f0 inParamDecl '<> param;' #txt
vr0 f0 actionDecl 'app.config.viewer.Data out;
' #txt
vr0 f0 guid 165D1DB99A73AF70 #txt
vr0 f0 requestEnabled true #txt
vr0 f0 triggerEnabled false #txt
vr0 f0 callSignature start() #txt
vr0 f0 caseData businessCase.attach=true #txt
vr0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
vr0 f0 @C|.responsibility Everybody #txt
vr0 f0 81 49 30 30 -25 17 #rect
vr0 f0 @|StartRequestIcon #fIcon
vr0 f1 type app.config.viewer.Data #txt
vr0 f1 337 49 30 30 0 15 #rect
vr0 f1 @|EndIcon #fIcon
vr0 f3 targetWindow NEW #txt
vr0 f3 targetDisplay TOP #txt
vr0 f3 richDialogId app.config.viewer.ConfigViewer #txt
vr0 f3 startMethod start() #txt
vr0 f3 type app.config.viewer.Data #txt
vr0 f3 requestActionDecl '<> param;' #txt
vr0 f3 responseActionDecl 'app.config.viewer.Data out;
' #txt
vr0 f3 responseMappingAction 'out=in;
' #txt
vr0 f3 isAsynch false #txt
vr0 f3 isInnerRd false #txt
vr0 f3 userContext '* ' #txt
vr0 f3 168 42 112 44 0 -7 #rect
vr0 f3 @|RichDialogIcon #fIcon
vr0 f4 expr out #txt
vr0 f4 111 64 168 64 #arcP
vr0 f2 expr out #txt
vr0 f2 280 64 337 64 #arcP
>Proto vr0 .type app.config.viewer.Data #txt
>Proto vr0 .processKind NORMAL #txt
>Proto vr0 0 0 32 24 18 0 #rect
>Proto vr0 @|BIcon #fIcon
vr0 f0 mainOut f4 tail #connect
vr0 f4 head f3 mainIn #connect
vr0 f3 mainOut f2 tail #connect
vr0 f2 head f1 mainIn #connect
