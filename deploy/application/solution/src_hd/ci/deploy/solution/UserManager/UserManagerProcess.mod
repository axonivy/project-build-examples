[Ivy]
15F259756E827FD8 3.23 #module
>Proto >Proto Collection #zClass
Us0 UserManagerProcess Big #zClass
Us0 RD #cInfo
Us0 #process
Us0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
Us0 @TextInP .rdData2UIAction .rdData2UIAction #zField
Us0 @TextInP .resExport .resExport #zField
Us0 @TextInP .type .type #zField
Us0 @TextInP .processKind .processKind #zField
Us0 @AnnotationInP-0n ai ai #zField
Us0 @MessageFlowInP-0n messageIn messageIn #zField
Us0 @MessageFlowOutP-0n messageOut messageOut #zField
Us0 @TextInP .xml .xml #zField
Us0 @TextInP .responsibility .responsibility #zField
Us0 @RichDialogInitStart f0 '' #zField
Us0 @RichDialogProcessEnd f1 '' #zField
Us0 @RichDialogProcessStart f3 '' #zField
Us0 @RichDialogEnd f4 '' #zField
Us0 @GridStep f6 '' #zField
Us0 @PushWFArc f7 '' #zField
Us0 @PushWFArc f5 '' #zField
Us0 @GridStep f8 '' #zField
Us0 @PushWFArc f9 '' #zField
Us0 @PushWFArc f2 '' #zField
>Proto Us0 Us0 UserManagerProcess #zField
Us0 f0 guid 15F25975795D214B #txt
Us0 f0 type ci.deploy.solution.UserManager.UserManagerData #txt
Us0 f0 method start() #txt
Us0 f0 disableUIEvents true #txt
Us0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
Us0 f0 outParameterDecl '<ci.deploy.base.User user> result;
' #txt
Us0 f0 outParameterMapAction 'result.user=in.user;
' #txt
Us0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Us0 f0 83 51 26 26 -20 15 #rect
Us0 f0 @|RichDialogInitStartIcon #fIcon
Us0 f1 type ci.deploy.solution.UserManager.UserManagerData #txt
Us0 f1 339 51 26 26 0 12 #rect
Us0 f1 @|RichDialogProcessEndIcon #fIcon
Us0 f3 guid 15F259757B76479D #txt
Us0 f3 type ci.deploy.solution.UserManager.UserManagerData #txt
Us0 f3 actionDecl 'ci.deploy.solution.UserManager.UserManagerData out;
' #txt
Us0 f3 actionTable 'out=in;
' #txt
Us0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Us0 f3 83 147 26 26 -16 12 #rect
Us0 f3 @|RichDialogProcessStartIcon #fIcon
Us0 f4 type ci.deploy.solution.UserManager.UserManagerData #txt
Us0 f4 guid 15F259757B83C606 #txt
Us0 f4 339 147 26 26 0 12 #rect
Us0 f4 @|RichDialogEndIcon #fIcon
Us0 f6 actionDecl 'ci.deploy.solution.UserManager.UserManagerData out;
' #txt
Us0 f6 actionTable 'out=in;
' #txt
Us0 f6 actionCode ivy.persistence.users.merge(in.user); #txt
Us0 f6 security system #txt
Us0 f6 type ci.deploy.solution.UserManager.UserManagerData #txt
Us0 f6 168 138 112 44 0 -7 #rect
Us0 f6 @|StepIcon #fIcon
Us0 f7 expr out #txt
Us0 f7 109 160 168 160 #arcP
Us0 f5 expr out #txt
Us0 f5 280 160 339 160 #arcP
Us0 f8 actionDecl 'ci.deploy.solution.UserManager.UserManagerData out;
' #txt
Us0 f8 actionTable 'out=in;
' #txt
Us0 f8 actionCode 'out.showDescription = Boolean.valueOf(ivy.var.ENABLE_USER_DESCRIPTION);' #txt
Us0 f8 type ci.deploy.solution.UserManager.UserManagerData #txt
Us0 f8 168 42 112 44 0 -7 #rect
Us0 f8 @|StepIcon #fIcon
Us0 f9 expr out #txt
Us0 f9 109 64 168 64 #arcP
Us0 f2 expr out #txt
Us0 f2 280 64 339 64 #arcP
>Proto Us0 .type ci.deploy.solution.UserManager.UserManagerData #txt
>Proto Us0 .processKind HTML_DIALOG #txt
>Proto Us0 -8 -8 16 16 16 26 #rect
>Proto Us0 '' #fIcon
Us0 f3 mainOut f7 tail #connect
Us0 f7 head f6 mainIn #connect
Us0 f6 mainOut f5 tail #connect
Us0 f5 head f4 mainIn #connect
Us0 f0 mainOut f9 tail #connect
Us0 f9 head f8 mainIn #connect
Us0 f8 mainOut f2 tail #connect
Us0 f2 head f1 mainIn #connect
