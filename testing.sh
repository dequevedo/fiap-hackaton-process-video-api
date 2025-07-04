curl -X POST http://localhost:8080/process-video \
  -H "Content-Type: multipart/form-data" \
  -F "file=@videos/video1.mp4;type=video/mp4" \
  -F "metadata={\"fileName\":\"Meu vídeo de teste\"}"
