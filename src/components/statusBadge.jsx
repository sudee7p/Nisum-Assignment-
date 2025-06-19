import React from 'react';
import classNames from 'classnames';
import './StatusBadge.css';

const StatusBadge = ({ status }) => {
  const badgeClass = classNames('status-badge', {
    success: status === 'success',
    error: status === 'error',
    warning: status === 'warning',
  });

  return <span className={badgeClass}>{status.toUpperCase()}</span>;
};

// Default prop
StatusBadge.defaultProps = {
  status: 'success',
};

export default StatusBadge;
