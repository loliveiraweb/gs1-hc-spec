# The Horizontal Communication Standard

The information on this page explains how horizontal communication works.

### What is Horizontal Communication?

If you are here, probably you are in developing something or you are in charge to manage a traceability project to follow the Brazil Regulation about the SNCM.

Based on the ANVISA´s decision to keep their efforts to handle only the Vertical Communication of the drug traceability, the market needs to find a way to improve the efficiency of the data exchange on the supply chain. 

This search for efficiency means that we need to have some standard interfaces to provide a faster onboarding of the trading partners in Brazil. If we start looking only on the private market, we have more than 70000 drugstores, 2000 distributors, and 400 pharmaceutical companies to connect. It can consume a lot of time (and money) when we look at the traditional approach that the service providers usually use to connect the trading partners.

In the image below you can see the *red line* representing the Vertical Communication that is the data exchange between the companies and the regulatory authority (ANVISA). In *blue* you can see what we are addressing in this standard that is the communication among trading partners in the supply chain..

![Horizontal Communication vs Vertical Communication](images/HorizontalComm.jpg)

### What does this standard implement?

This standard developed by a GS1 Brazil Workgroup developed some common artifacts that enable the interoperability between trading partners. These artifacts are basically a set of Interfaces and Messages that act as a glue between companies in the supply chain. The messages here developed implements a **Transport Layer** and are basically an Envelope that carries the SNCM (or any other) information from one Trading Partner to another. The messages usually do not implement any Business Rule or limit the content to be delivered allowing the companies to exchange many types of files such as **SNCM** messages, **EPCIS**, **Electronic Invoice**, etc.

Additionally, the standard implements a common Query Interface that enables the companies to query information on the HC Databases. It means that the standard enables a pushing or pulling strategy.

![Two Way Communication](images/PushPull.jpg)

### What do we have inside the HC Standard?

The standard basically implements a Webservice with 3 simple methods that allow the data exchange between the companies. In addition, we also developed some XML artifacts that can act as an Envelope to provide a standard way to package and route messages among the supply chain.

### What is the technology and security of the HC Standard?

At the beginning of the work, the workgroup made some assumptions to speed up the development and put the focus on the most important points to work. 

The main assumption was that we do not need to stay focused on the technology because it can become an infinite loop. Nowadays we have many good alternatives on the market and each member of the group could have their own preferences. 

Based on that, we have decided to keep the same stack that ANVISA is using. With this strategy, we can save time discussing the technology and can save a lot of money in terms of software development because the same developer that needs to implement the vertical connection to the SNCM also can develop horizontal communication.

In this way, we are following the same stack of the SNCM System that means:

- The use of the SSL (Secure Shell Layer) over HTTP communication.

- Mutual Authentication using the ICP-Brasil Digital certificates

- Electronic Signature on the XML messages to assure the authenticity and integrity of the messages.

- SOAP Webservices


![image info](images/authSchema.png)


Below you can find a Sample Signed message with the specific tags needed by the XML Signature using X509 Certificates.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<InboundMessage xmlns="http://hc.gs1br.org.br/" date="2021-10-01T16:42:00Z" id="123456978696050595050AAAABBBDDDDD">
	<sender>
		<partnerKey>CNPJ</partnerKey>
		<partnerValue>15042274000195</partnerValue>
	</sender>
	<receiver>
		<partnerKey>CNPJ</partnerKey>
		<partnerValue>15041786000176</partnerValue>
	</receiver>
	<carrier>
		<partnerKey>CNPJ</partnerKey>
		<partnerValue>15042274000195</partnerValue>
	</carrier>
	<content>
		<fileURL>https://sampleurl.sampledomain.com/fileXXXXXXXX.xml</fileURL>
	</content>
	<Signature xmlns="http://www.w3.org/2000/09/xmldsig#">
		<SignedInfo>
			<CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/>
			<SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/>
			<Reference URI="">
				<Transforms>
					<Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature"/>
				</Transforms>
				<DigestMethod Algorithm="http://www.w3.org/2000/09/xmldsig#sha1"/>
				<DigestValue>1qLlpV5ntvfZyx2rn9DAreSAD1c=</DigestValue>
			</Reference>
		</SignedInfo>
		<SignatureValue>kL2Y/AaOnFnubSClHJiPZTSOpfYDh6QYQZqbgxX4VPgf9kTbIJIzHogDtdFoxg2gGQN+bUDpyaOw&#13;
TH6qdegUJKQa+s2zrI60vAEulFCltzt9l9dIDDKeo0mNHk2GRb2qnOnJ7rHmyY5Qrjuoq0hTHSJp&#13;
uvbFfYEyIQLJ2Htld3bj5P1L1ghANw0NZKq01QpblGZLei9c4Z6fRtLhyczR08UEc8gIxWKFASJd&#13;
OvNfHqAJLEzcYIP0AzZXwSreJtM3ZOXGimipbCoJjUsAZ31c8d/EUsfUu2ez5BT6m0ICXbIUP+cG&#13;
yo5UJnfAj1bcoy27Dm0w8NrfqBVtwkuWCyVhxg==</SignatureValue>
		<KeyInfo>
			<X509Data>
				<X509SubjectName>CN=T2 SOFTWARE S A:15042274000195,OU=RFB e-CNPJ A1,OU=Secretaria da Receita Federal do Brasil - RFB,OU=29277404000109,OU=VideoConferencia,L=Sao Paulo,ST=SP,O=ICP-Brasil,C=BR</X509SubjectName>
				<X509Certificate>MIIIAjCCBeqgAwIBAgIQC2LioAcGdMmoSdIbjUEVazANBgkqhkiG9w0BAQsFADB4MQswCQYDVQQG&#13;
EwJCUjETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBSZWNlaXRh&#13;
IEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRwwGgYDVQQDExNBQyBDZXJ0aXNpZ24gUkZCIEc1MB4X&#13;
DTIxMDMxOTE5NTczMVoXDTIyMDMxOTE5NTczMVowgfAxCzAJBgNVBAYTAkJSMRMwEQYDVQQKDApJ&#13;
Q1AtQnJhc2lsMQswCQYDVQQIDAJTUDESMBAGA1UEBwwJU2FvIFBhdWxvMRkwFwYDVQQLDBBWaWRl&#13;
b0NvbmZlcmVuY2lhMRcwFQYDVQQLDA4yOTI3NzQwNDAwMDEwOTE2MDQGA1UECwwtU2VjcmV0YXJp&#13;
YSBkYSBSZWNlaXRhIEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRYwFAYDVQQLDA1SRkIgZS1DTlBK&#13;
IEExMScwJQYDVQQDDB5UMiBTT0ZUV0FSRSBTIEE6MTMwNDIyNzQwMDAxOTUwggEiMA0GCSqGSIb3&#13;
DQEBAQUAA4IBDwAwggEKAoIBAQC+18QseqwK5EVEKMLwifPHOmxG4V/Sj5RhBB4x9bX9UdtC1d8J&#13;
/mJhaHRiIiAQSwvPrj0TDyO/3FHoip6KY5/WcMXH6xzMgRkq2zPhWuYUqAQbWSaYXRvBgmN0ifRr&#13;
y8NWXXyrzXBtTJf5Xalh8wvXDA92BrPHjy/a1uicajXDsz7mOWNFTTU6xH/fqcKDx19zb5/+7TCp&#13;
eeLWp+rhcKiiq5TylEVibGX8O49LaXq8NjDmvx4/+xh9/BUO6hGnpyqyiqVkfd7HVd1q8lB/3jV0&#13;
ERA5AQPIiHmJCIAyQMeQZUsgVCCO9ntEok2YEpPiBpc1Qz9h8OsK8KQ9biaPFhn1AgMBAAGjggMN&#13;
MIIDCTCBvAYDVR0RBIG0MIGxoD0GBWBMAQMEoDQEMjA4MTIxOTc5MjE2MjU2MjU4ODAwMDAwMDAw&#13;
MDAwMDAwMDAwMDI5MjkxNjA5N1NTUFNQoB8GBWBMAQMCoBYEFFJPRFJJR08gS0xFSU4gU0FOVE9T&#13;
oBkGBWBMAQMDoBAEDjEzMDQyMjc0MDAwMTk1oBcGBWBMAQMHoA4EDDAwMDAwMDAwMDAwMIEbQ0FS&#13;
T0xJTkUuUEFVTElOT0BCRE8uQ09NLkJSMAkGA1UdEwQCMAAwHwYDVR0jBBgwFoAUU31/nb7RYdAg&#13;
utqf44mnE3NYzUIwfwYDVR0gBHgwdjB0BgZgTAECAQwwajBoBggrBgEFBQcCARZcaHR0cDovL2lj&#13;
cC1icmFzaWwuY2VydGlzaWduLmNvbS5ici9yZXBvc2l0b3Jpby9kcGMvQUNfQ2VydGlzaWduX1JG&#13;
Qi9EUENfQUNfQ2VydGlzaWduX1JGQi5wZGYwgbwGA1UdHwSBtDCBsTBXoFWgU4ZRaHR0cDovL2lj&#13;
cC1icmFzaWwuY2VydGlzaWduLmNvbS5ici9yZXBvc2l0b3Jpby9sY3IvQUNDZXJ0aXNpZ25SRkJH&#13;
NS9MYXRlc3RDUkwuY3JsMFagVKBShlBodHRwOi8vaWNwLWJyYXNpbC5vdXRyYWxjci5jb20uYnIv&#13;
cmVwb3NpdG9yaW8vbGNyL0FDQ2VydGlzaWduUkZCRzUvTGF0ZXN0Q1JMLmNybDAOBgNVHQ8BAf8E&#13;
BAMCBeAwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMIGsBggrBgEFBQcBAQSBnzCBnDBf&#13;
BggrBgEFBQcwAoZTaHR0cDovL2ljcC1icmFzaWwuY2VydGlzaWduLmNvbS5ici9yZXBvc2l0b3Jp&#13;
by9jZXJ0aWZpY2Fkb3MvQUNfQ2VydGlzaWduX1JGQl9HNS5wN2MwOQYIKwYBBQUHMAGGLWh0dHA6&#13;
Ly9vY3NwLWFjLWNlcnRpc2lnbi1yZmIuY2VydGlzaWduLmNvbS5icjANBgkqhkiG9w0BAQsFAAOC&#13;
AgEAAd8T+YgIGpCB9gkEU4k1GCNV6Cyn3aGT0jjsk0w82weVFl7fgpSC/BBqmi53V8oHrEBd3nUU&#13;
KTdYM++iGP/mPEYIx8pmWXmgzdyol8Kd49zhUSCF+uc5WYu8/UAaX+44Af8nd/T30hlFKWy6C/jo&#13;
ES1XEhZU20u0SKVWtcLUjnupgSB7Hicv1SvF5jP7Zz7FiaFKdzOci9p/e2QP5Qv5vtpfiOXVJdYY&#13;
oM5OYCjT3xVMubj5qsmT/3LE9np4fviBoAereb+AFSfaHiticLH9dfE149TYfm23Z1Yc4GxdwsFO&#13;
EB1Jgntfk1PIZ8S8HjvFx4oxcqcov/N7xuvSRq3R3oBg6Y/2AWjIr2bCM2ya2PwgeefBTrFHnRkB&#13;
iLMkUkLdILqf6qkoKgU31Cr6/ecZqKWcGpTUG7ZeB1wm1BISJQFRMe1ueweu21SW2IAt/a//HlNg&#13;
US7p7gdi2gN/OrexJULyKsXPVJ8BizAXL5CnV3SBsuCgmqcssgL09uFiqu/vOukqS2DoMTgRJirL&#13;
hVTHGLvFjE5rTyU45i+K5+WwkCB2ZgFRY1oDwwefsQjzuWeeRLrAZVHhixgfkhq1md9cFcuyxXX9&#13;
cz5I8hk6KZenuax1QFFEoi3xsSXSNZWrUnZGYMlmQVb3D6MBtibst4zU3fOWYvuf4k8+cBzL1Ltb&#13;
sJ8=</X509Certificate>
			</X509Data>
		</KeyInfo>
	</Signature>
</InboundMessage>
```

### Anatomy of the Webservice

The technology behind the main interface of Horizontal Communication is SOAP (Simple Object Access Protocol). This technology is a well-known technology that many companies already have developers that knows it.

The Standard has only one web service which contains 3 methods that enable communication.

The web service named DataWS is responsible to make available the methods below.

| Method | Description | Input | Return|
|--------|-------------|--------|--------|
|sendMessage|Method responsible to provide a standard way to receive messages| [InboundMessage](SoapUI_Requests/sendMessageRequest.xml) |[InboundResponse](SoapUI_Requests/sendMessageResponse.xml)|
|getMessage| Method responsible to provide a query interface with the system| [QueryRequest](SoapUI_Requests/getMessageRequest.xml) |[QueryResponse](SoapUI_Requests/getMessageResponse.xml) |
|getPreferences|Method responsible to provide the partner preferences to the network| [QueryRequest](SoapUI_Requests/getPreferencesRequest.xml) |[PreferenceData](SoapUI_Requests/getPreferencesResponse.xml)|

For more information about the webservice, please look at the WSDL file.

[DataWS - Web Service Descriptor Language](WSDL/DataWS.wsdl)

### Messages

As we told before, the standard is a set of artifacts that can enable the communication between trading partners acting as a glue between them. To perform this task using the webservice above, we need to have a set of Messages that can be used as an Envelope to enable the routing between the parts.

Below you can see the list of the Sample Messages

| Message  | Purpose | Sample File | Reference |
|----------|---------|-------------|-----------|
| Authorization | Provide a way to inform the Attorney of a specific trading partner | [Authorization_SIGNED.xml](XML_Samples/Authorization_SIGNED.xml)| [Reference](References/Authorization.md) |
| InboundMessage | The standard Message to send information to a Trading Partner (Pushing Strategy) | [inboundMessageBase64_SIGNED.xml](XML_Samples/inboundMessageBase64_SIGNED.xml)| [Reference](References/InboundMessage.md) |
| InboundMessage | The standard Message to send information to a Trading Partner using the URL Option (Pushing Strategy) | [inboundMessageFileURL_SIGNED.xml](XML_Samples/inboundMessageFileURL_SIGNED.xml)| [Reference](References/InboundMessage.md) |
| InboundMessage | The standard Message to send information to a Trading Partner with the Attorney Option | [xmlFileInboundMessageWA_SIGNED.xml](XML_Samples/xmlFileInboundMessageWA_SIGNED.xml)| [Reference](References/InboundMessage.md) |
| inboundResponseReceipt | The receipt Message received by a Sender when send the Inbound Message to a Trading Partner | [inboundResponseReceipt_SIGNED.xml](XML_Samples/inboundResponseReceipt_SIGNED.xml)| [Reference](References/InboundResponseReceipt.md) |
| inboundResponseError | The Message received by a Sender when we have some error on the communication | [inboundResponseError_SIGNED.xml](XML_Samples/inboundResponseError_SIGNED.xml)| [Reference](References/InboundResponseReceipt.md#fields-of-the-message-with-error) |
| QueryRequest | Query Message to ask for Messages in the server (Pulling Strategy) | [queryRequest_SIGNED.xml](XML_Samples/queryRequest_SIGNED.xml)| [Reference](References/QueryRequest.md) |
| QueryResponse | Response Message returned by the server in getMessage method | [queryResponse_SIGNED.xml](XML_Samples/queryResponse_SIGNED.xml)| [Reference](References/QueryResponse.md) |
| PreferenceData | Message returned by the getPreferences method which expose the Trading Partner Preferences | [preferenceData_SIGNED.xml](XML_Samples/preferenceData_SIGNED.xml)| [Reference](References/PreferenceData.md) |

### Hands on!

Here we can demonstrate how choreography works in the practice.

#### Sample Workflow

Below you can see the real behavior of the standard and how it works.

| Workflow  | Description |  Reference |
|-----------|-------------|------------|
| Shipment  | This workflow demonstrates how to send a Message to a Trading Partner |  [Reference](Workflow_Samples/ShipmentSample.md) |
| Receiving  | This workflow demonstrate how to confirm to a trading partner the receiving of the serialized products |  [Reference](Workflow_Samples/ReceivingSample.md) |
| Query Messages   | This workflow demonstrate how to query Messages from a Trading Partner |  [Reference](Workflow_Samples/QueryMessages.md) |
| Query Preferences   | This workflow demonstrate how to query Preferences from a Trading Partner |  [Reference](Workflow_Samples/QueryPreferences.md) |
| Query a Receipt   | This workflow demonstrate how to query to retrieve the results of a sending |  [Reference](Workflow_Samples/QueryReceipt.md) |

