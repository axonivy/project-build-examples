[Ivy]
16FEC4E2785D3F8D 7.5.0 #module
>Proto >Proto Collection #zClass
Cr0 Customer Big #zClass
Cr0 B #cInfo
Cr0 #process
Cr0 @TextInP .type .type #zField
Cr0 @TextInP .processKind .processKind #zField
Cr0 @TextInP .xml .xml #zField
Cr0 @TextInP .responsibility .responsibility #zField
Cr0 @StartRequest f0 '' #zField
Cr0 @EndTask f1 '' #zField
Cr0 @UserDialog f3 '' #zField
Cr0 @PushWFArc f4 '' #zField
Cr0 @PushWFArc f2 '' #zField
>Proto Cr0 Cr0 Customer #zField
Cr0 f0 outLink orderProduct.ivp #txt
Cr0 f0 inParamDecl '<> param;' #txt
Cr0 f0 requestEnabled true #txt
Cr0 f0 triggerEnabled false #txt
Cr0 f0 callSignature orderProduct() #txt
Cr0 f0 caseData businessCase.attach=true #txt
Cr0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>orderProduct.ivp</name>
    </language>
</elementInfo>
' #txt
Cr0 f0 @C|.responsibility Everybody #txt
Cr0 f0 81 49 30 30 -53 22 #rect
Cr0 f0 @|StartRequestIcon #fIcon
Cr0 f1 337 49 30 30 0 15 #rect
Cr0 f1 @|EndIcon #fIcon
Cr0 f3 dialogId ch.ivyteam.ivy.project.demo.ci.order.OrderForm #txt
Cr0 f3 startMethod start() #txt
Cr0 f3 requestActionDecl '<> param;' #txt
Cr0 f3 responseMappingAction 'out=in;
out.order=result.order;
' #txt
Cr0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>order products</name>
    </language>
</elementInfo>
' #txt
Cr0 f3 168 42 112 44 -47 -7 #rect
Cr0 f3 @|UserDialogIcon #fIcon
Cr0 f4 111 64 168 64 #arcP
Cr0 f2 280 64 337 64 #arcP
>Proto Cr0 .type ch.ivyteam.ivy.project.demo.ci.order.Data #txt
>Proto Cr0 .processKind NORMAL #txt
>Proto Cr0 0 0 32 24 18 0 #rect
>Proto Cr0 @|BIcon #fIcon
Cr0 f0 mainOut f4 tail #connect
Cr0 f4 head f3 mainIn #connect
Cr0 f3 mainOut f2 tail #connect
Cr0 f2 head f1 mainIn #connect
