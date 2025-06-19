import React from 'react';
import StatusBadge from './StatusBadge';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <StatusBadge status="success" />
      <StatusBadge status="error" />
      <StatusBadge status="warning" />
      <StatusBadge /> {/* default: success */}
    </div>
  );
}

export default App;
