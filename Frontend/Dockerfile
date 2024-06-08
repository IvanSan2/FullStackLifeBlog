# Step 1: Use an official Node.js runtime as the base image
FROM node:18-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy package.json and yarn.lock to the container
COPY package.json yarn.lock ./

# Step 4: Install dependencies
RUN yarn install

# Optional: Install sharp for image optimization
RUN yarn add sharp

# Step 5: Copy the rest of your application code to the container
COPY . .

# Step 6: Build the Next.js app
RUN yarn build

# Step 7: Expose the port the app runs on
EXPOSE 3000

# Step 8: Define the command to run the app
CMD ["yarn", "start"]
