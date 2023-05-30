 spring:  security:     oauth2:       client:         provider:           keycloak:             issuer-uri: https://host/keycloak/auth/realms/ourrealm         registration:           keycloak:             client-id: client_id             client-secret: client-secret-here             authorization-grant-type: client_credentials     //need to add explicitly, otherwise would try other grant-type by default and never get the token!             client-authentication-method: post //need to have this explicitly, otherwise use basic that doesn't fit best the keycloak set up             scope: openid //if your don't have it, it checks all available scopes on url like https://host/keycloak/auth/realms/ourrealm/ .well-known/openid-configuration keycloak and then sends them as value of parameter named 'scope' in the query for retrieving the token; that works wrong on our keycloak, so to replace this auto-picked value, we place the explicit scopes list here