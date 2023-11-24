# Use the official Packer Docker image as the base
FROM hashicorp/packer:1.9

# Install curl and git
USER root
RUN apk --no-cache add curl git

# Create a non-root user with a home directory
RUN addgroup -S jenkins && adduser -S -G jenkins jenkins

# Set the working directory
WORKDIR /home/jenkins

# Switch to the non-root user
USER jenkins

# No need to specify CMD, as it will be overridden by Jenkins

# No ENTRYPOINT to allow Jenkins to override it
