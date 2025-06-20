import React, { useEffect, useState } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';
import products from './products.json';

export default function ProductDetail() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    const found = products.find(p => p.id === parseInt(id));
    setProduct(found);
  }, [id]);

  if (!product) return <p>Loading product...</p>;

  return (
    <div style={{ padding: '20px' }}>
      <nav style={{ marginBottom: '10px' }}>
        <Link to="/">Home</Link> &gt; <span>{product.name}</span>
      </nav>

      <button onClick={() => navigate(-1)}>⬅️ Go Back</button>

      <h2>{product.name}</h2>
      <img src={product.image} alt={product.name} />
      <p><strong>Price:</strong> ${product.price}</p>
      <p><strong>Description:</strong> {product.description}</p>
      <p><strong>Stock:</strong> {product.stock ? 'In Stock' : 'Out of Stock'}</p>
    </div>
  );
}
