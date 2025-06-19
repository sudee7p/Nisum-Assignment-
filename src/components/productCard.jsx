import React from 'react';

const ProductCard = ({ title, price, description }) => {
  return (
    <div style={cardStyle}>
      <h2>{title}</h2>
      <p>Price: ${price}</p>
      <p>{description}</p>
    </div>
  );
};

// Default props
ProductCard.defaultProps = {
  title: 'Unknown Product',
  price: 0,
  description: 'No description available.'
};

const cardStyle = {
  border: '1px solid #ddd',
  padding: '15px',
  borderRadius: '8px',
  width: '300px',
  margin: '10px',
  fontFamily: 'Arial'
};

export default ProductCard;
