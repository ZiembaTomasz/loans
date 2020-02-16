# Build docker images

Add user to docker group
```
sudo usermod -aG docker $USER
```

./mvnw package docker:build