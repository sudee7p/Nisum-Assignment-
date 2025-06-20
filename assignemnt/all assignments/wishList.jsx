import React from 'react';
import products from './products.json';
import { useWishlist } from './useWishlist';
import { Link } from 'react-router-dom';

export default function WishlistPage() {
  const { wishlist, toggleWishlist } = useWishlist();
  const wishlistedProducts = products.filter(p => wishlist.includes(p.id));

  return (
    <div style={{ padding: '20px' }}>
      <h2>❤️ Your Wishlist</h2>
      <Link to="/">⬅️ Back to Products</Link>
      {wishlistedProducts.length === 0 ? (
        <p>No items in wishlist.</p>
      ) : (
        <ul>
          {wishlistedProducts.map(p => (
            <li key={p.id} style={{ margin: '10px 0' }}>
              {p.name} - ${p.price}
              <button
                onClick={() => toggleWishlist(p.id)}
                style={{ marginLeft: '10px', color: 'red' }}
              >
                ❤️ Remove
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
