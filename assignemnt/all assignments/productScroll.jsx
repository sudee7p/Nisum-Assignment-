import React, { useEffect, useRef, useState } from 'react';
import allProducts from './products.json';

export default function ProductScroll() {
  const PAGE_SIZE = 3;
  const categories = ['All', 'Electronics', 'Fashion', 'Home'];

  const [category, setCategory] = useState('All');
  const [page, setPage] = useState(1);
  const [products, setProducts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const loaderRef = useRef();

  const fetchPage = () => {
    setIsLoading(true);
    setTimeout(() => {
      const filtered = category === 'All'
        ? allProducts
        : allProducts.filter(p => p.category === category);

      const next = filtered.slice(0, page * PAGE_SIZE);
      setProducts(next);
      setIsLoading(false);
    }, 500); // Simulate API delay
  };

  // Load more on scroll
  useEffect(() => {
    const observer = new IntersectionObserver(entries => {
      if (entries[0].isIntersecting) {
        setPage(prev => prev + 1);
      }
    }, { threshold: 1 });

    if (loaderRef.current) observer.observe(loaderRef.current);
    return () => observer.disconnect();
  }, []);

  // Fetch whenever category or page changes
  useEffect(() => {
    fetchPage();
  }, [category, page]);

  // Reset scroll and page when category changes
  const changeCategory = (cat) => {
    setCategory(cat);
    setPage(1);
    setProducts([]);
    window.scrollTo({ top: 0, behavior: 'smooth' });
  };

  return (
    <div style={{ padding: '20px' }}>
      <h2>🛍️ Infinite Scroll with Categories</h2>

      <div style={{ marginBottom: '10px' }}>
        {categories.map(cat => (
          <button
            key={cat}
            onClick={() => changeCategory(cat)}
            style={{
              marginRight: '10px',
              backgroundColor: category === cat ? '#333' : '#ccc',
              color: '#fff',
              border: 'none',
              padding: '5px 10px',
              borderRadius: '5px',
              cursor: 'pointer'
            }}
          >
            {cat}
          </button>
        ))}
      </div>

      <ul>
        {products.map(p => (
          <li key={p.id}>{p.name} - {p.category}</li>
        ))}
      </ul>

      {isLoading && <p>Loading more products...</p>}
      <div ref={loaderRef} style={{ height: '20px' }}></div>
    </div>
  );
}
