import axios from "axios";
import React, { useState, Component, useEffect } from "react";
import Post from "./Post";
import PostDetails from "./PostDetails";

export default function Posts(refreshFlag) {
  const [posts, setPosts] = useState([]);
  const [selectedPost, setSelectedPost] = useState("");
  const updateSelected = (selected) => selectedPost(selected);
  const [refresh, setRefresh] = useState(null);

  useEffect(() => {
    console.log(selectedPost);
  }, [selectedPost]);

  useEffect(() => {
    axios
      .get("/posts")
      .then((res) => {
        setPosts(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [refresh, refreshFlag]);

  return (
    <div className="posts">
      {posts.map((post, key) => (
        <Post key={post.id} post={post} selectedPost={setSelectedPost} />
      ))}
      {selectedPost && <PostDetails post={selectedPost} refresh={setRefresh} />}
    </div>
  );
}
