import React from 'react';
import { Link } from 'react-router-dom';
import products from './products.json';

export default function ProductList() {
  return (
    <div style={{ padding: '20px' }}>
      <h2>Product List</h2>
      <ul>
        {products.map(p => (
          <li key={p.id}>
            <Link to={`/products/${p.id}`}>{p.name}</Link> - ${p.price}
          </li>
        ))}
      </ul>
    </div>
  );
}
