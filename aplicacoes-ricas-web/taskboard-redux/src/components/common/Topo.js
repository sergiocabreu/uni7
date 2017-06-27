import React from 'react';

const Topo = () => {
  return (
    <nav className="indigo darken-4" role="navigation">
      <div className="nav-wrapper container">
        <a id="logo-container" href="#" className="brand-logo">React Taskboard</a>
        <ul className="right">
          <li><a href="/">Taskboard</a></li>
          <li><a href="/about">Sobre</a></li>
          <li><a href="/devs">Devs</a></li>
        </ul>
      </div>
    </nav>
  );
};
export default Topo;