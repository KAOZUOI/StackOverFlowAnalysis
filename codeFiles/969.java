spring:  ssl:    bundle:      pem:        rest:          keystore:            certificate: &quot;/etc/identity/client/certificates/client.pem&quot;            private-key: &quot;/etc/identity/client/keys/client-key.pkcs8&quot;          truststore:             certificate: &quot;/etc/pki_service/ca/cacerts.pem&quot;