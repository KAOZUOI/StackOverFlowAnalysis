Cipher cipher = Cipher.getInstance(&quot;RSA/ECB/NoPadding&quot;, &quot;SunPKCS11-cknfast0&quot;);cipher.init(Cipher.DECRYPT_MODE, privatePK11Key); decrypted = cipher.doFinal(data);