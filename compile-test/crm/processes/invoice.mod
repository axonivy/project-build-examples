[Ivy]
1720E35BB7789886 9.3.0 #module
>Proto >Proto Collection #zClass
ie0 invoice Big #zClass
ie0 B #cInfo
ie0 #process
ie0 @TextInP .type .type #zField
ie0 @TextInP .processKind .processKind #zField
ie0 @TextInP .xml .xml #zField
ie0 @TextInP .responsibility .responsibility #zField
ie0 @StartRequest f0 '' #zField
ie0 @EndTask f1 '' #zField
ie0 @UserTask f2 '' #zField
ie0 @TkArc f3 '' #zField
ie0 @PushWFArc f4 '' #zField
ie0 @StartRequest f5 '' #zField
ie0 @UserDialog f6 '' #zField
ie0 @EndTask f7 '' #zField
ie0 @PushWFArc f8 '' #zField
ie0 @PushWFArc f9 '' #zField
ie0 @EndTask f12 '' #zField
ie0 @StartRequest f10 '' #zField
ie0 @TkArc f13 '' #zField
ie0 @UserTask f11 '' #zField
ie0 @PushWFArc f14 '' #zField
>Proto ie0 ie0 invoice #zField
ie0 f0 outLink writeInvoice.ivp #txt
ie0 f0 inParamDecl '<crm.Order Order> param;' #txt
ie0 f0 inParamTable 'out.valid=false;
' #txt
ie0 f0 requestEnabled true #txt
ie0 f0 triggerEnabled false #txt
ie0 f0 callSignature writeInvoice(crm.Order) #txt
ie0 f0 taskData 'TaskTriggered.NAM=start write invoice' #txt
ie0 f0 caseData businessCase.attach=true #txt
ie0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>writeInvoice.ivp</name>
    </language>
</elementInfo>
' #txt
ie0 f0 @C|.responsibility Everybody #txt
ie0 f0 81 49 30 30 -23 18 #rect
ie0 f1 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>end</name>
    </language>
</elementInfo>
' #txt
ie0 f1 337 49 30 30 -10 17 #rect
ie0 f2 dialogId crm.InvoiceForm #txt
ie0 f2 startMethod start() #txt
ie0 f2 requestActionDecl '<> param;' #txt
ie0 f2 responseMappingAction 'out=in;
out.total=result.total;
' #txt
ie0 f2 taskData 'TaskA.NAM=write invoice
TaskA.ROL=Everybody
TaskA.TYPE=0' #txt
ie0 f2 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>write invoice</name>
    </language>
</elementInfo>
' #txt
ie0 f2 168 42 112 44 -38 -7 #rect
ie0 f3 111 64 168 64 #arcP
ie0 f4 280 64 337 64 #arcP
ie0 f5 outLink checkOrder.ivp #txt
ie0 f5 inParamDecl '<> param;' #txt
ie0 f5 requestEnabled true #txt
ie0 f5 triggerEnabled false #txt
ie0 f5 callSignature checkOrder() #txt
ie0 f5 caseData businessCase.attach=true #txt
ie0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>checkOrder.ivp</name>
    </language>
</elementInfo>
' #txt
ie0 f5 @C|.responsibility Everybody #txt
ie0 f5 81 177 30 30 -25 17 #rect
ie0 f6 dialogId crm.CheckOrderForm #txt
ie0 f6 startMethod start(Boolean) #txt
ie0 f6 requestActionDecl '<Boolean valid> param;' #txt
ie0 f6 responseMappingAction 'out=in;
' #txt
ie0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>check order</name>
    </language>
</elementInfo>
' #txt
ie0 f6 168 170 112 44 -37 -7 #rect
ie0 f7 337 177 30 30 0 15 #rect
ie0 f8 111 192 168 192 #arcP
ie0 f9 280 192 337 192 #arcP
ie0 f12 337 305 30 30 0 15 #rect
ie0 f10 outLink prepareShipment.ivp #txt
ie0 f10 inParamDecl '<> param;' #txt
ie0 f10 requestEnabled true #txt
ie0 f10 triggerEnabled false #txt
ie0 f10 callSignature prepareShipment() #txt
ie0 f10 taskData 'TaskTriggered.NAM=start prepare shipment' #txt
ie0 f10 caseData businessCase.attach=true #txt
ie0 f10 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>prepareShipment.ivp</name>
    </language>
</elementInfo>
' #txt
ie0 f10 @C|.responsibility Everybody #txt
ie0 f10 81 305 30 30 -25 17 #rect
ie0 f13 111 320 160 320 #arcP
ie0 f11 dialogId crm.ShipmentForm #txt
ie0 f11 startMethod start() #txt
ie0 f11 requestActionDecl '<> param;' #txt
ie0 f11 responseMappingAction 'out=in;
' #txt
ie0 f11 taskData 'TaskA.NAM=prepare shipment
TaskA.ROL=CREATOR
TaskA.TYPE=0' #txt
ie0 f11 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>prepare shipment</name>
    </language>
</elementInfo>
' #txt
ie0 f11 160 298 128 44 -56 -7 #rect
ie0 f14 288 320 337 320 #arcP
>Proto ie0 .type crm.Order #txt
>Proto ie0 .processKind NORMAL #txt
>Proto ie0 0 0 32 24 18 0 #rect
>Proto ie0 @|BIcon #fIcon
ie0 f0 mainOut f3 tail #connect
ie0 f3 head f2 in #connect
ie0 f2 out f4 tail #connect
ie0 f4 head f1 mainIn #connect
ie0 f5 mainOut f8 tail #connect
ie0 f8 head f6 mainIn #connect
ie0 f6 mainOut f9 tail #connect
ie0 f9 head f7 mainIn #connect
ie0 f10 mainOut f13 tail #connect
ie0 f13 head f11 in #connect
ie0 f11 out f14 tail #connect
ie0 f14 head f12 mainIn #connect
