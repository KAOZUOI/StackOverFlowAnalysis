public byte[] getFileBytes(@RequestBody ZeusRequestVO<String> request) {    return documentService.downloadFileByChunks(request).toByteArray();}