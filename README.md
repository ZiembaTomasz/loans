# Build docker images

Add user to docker group
```
sudo usermod -aG docker $USER
```

./mvnw package docker:build





./mvnw clean compile && ./mvnw package docker:build

docker run -p 3306:3306 ziembatomasz/database:1.0

