import React from 'react';
import products from './products.json';
import { useCart } from './CartContext';
import { Link } from 'react-router-dom';

export default function ProductList() {
  const { addToCart, cart } = useCart();

  return (
    <div style={{ padding: '20px' }}>
      <h2>🛒 Product List</h2>
      <Link to="/cart">Go to Cart ({cart.length})</Link>
      <ul>
        {products.map(p => (
          <li key={p.id}>
            {p.name} - ${p.price}
            <button onClick={() => addToCart(p)} style={{ marginLeft: '10px' }}>
              Add to Cart
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
