import React from 'react';

const ProductEdit = () => {
  return (
    <div>
      <h2>Edit Product</h2>
      <form>
        <input type="text" placeholder="Product Name" />
        <input type="number" placeholder="Price" />
        <button type="submit">Update</button>
      </form>
    </div>
  );
};

export default ProductEdit;
