// send request to backend using jwt token
export const backendConnection = async (urlEndPoint, method, token, body) => {
  try {
    const response = await fetch(process.env.BACKEND_URL + urlEndPoint, {
      method: method,
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(body),
    });
    return await response.json();
  } catch (error) {
    console.error(error);
  }
};
