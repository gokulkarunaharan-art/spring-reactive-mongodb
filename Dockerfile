# Use the official MongoDB image as the base
FROM mongo:latest

# Optional: Set environment variables directly in the image
# (Though it's usually safer to pass these at runtime)
ENV MONGO_INITDB_ROOT_USERNAME=admin
ENV MONGO_INITDB_ROOT_PASSWORD=password

# Expose the default MongoDB port
EXPOSE 27017

# No need for a CMD; the base image already has the logic to start Mongo