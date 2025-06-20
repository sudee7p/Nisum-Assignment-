import React from 'react';
import products from './products.json';
import { useWishlist } from './useWishlist';
import { Link } from 'react-router-dom';

export default function ProductList() {
  const { toggleWishlist, isWishlisted } = useWishlist();

  return (
    <div style={{ padding: '20px' }}>
      <h2>Products</h2>
      <Link to="/wishlist">❤️ View Wishlist</Link>
      <ul>
        {products.map(p => (
          <li key={p.id} style={{ margin: '10px 0' }}>
            {p.name} - ${p.price}
            <button
              onClick={() => toggleWishlist(p.id)}
              style={{ marginLeft: '10px', color: isWishlisted(p.id) ? 'red' : 'gray' }}
            >
              {isWishlisted(p.id) ? '❤️' : '🤍'}
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
