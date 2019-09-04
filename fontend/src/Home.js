import React from 'react';
import Sidebar from "./sidebar";


import "bootstrap/dist/css/bootstrap.min.css";

export default props => {
    return (
        <div>
          <meta httpEquiv="X-UA-Compatible" content="IE=edge" />
          <meta name="generator" content="Mobirise v4.10.8, mobirise.com" />
          <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1" />
          <link rel="shortcut icon" href="assets/images/mbr-122x122.jpg" type="image/x-icon" />
          <meta name="description" content />
          <title>Home</title>
          <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css" />
          <link rel="stylesheet" href="assets/tether/tether.min.css" />
          <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
          <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css" />
          <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css" />
          <link rel="stylesheet" href="assets/dropdown/css/style.css" />
          <link rel="stylesheet" href="assets/theme/css/style.css" />
          <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css" />
          <section className="menu cid-rB4nPyNx2i" once="menu" id="menu2-0">
            <nav className="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
              <button className="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <div className="hamburger">
                  <span />
                  <span />
                  <span />
                  <span />
                </div>
              </button>
              <div className="menu-logo">
                <div className="navbar-brand">
                  <span className="navbar-caption-wrap"><a className="navbar-caption text-primary display-5" href="#">SMARTBUSTICKETING</a></span>
                </div>
              </div>
              <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav nav-dropdown" data-app-modern-menu="true"><li className="nav-item">
                    <a className="nav-link link text-black display-4" href="#">
                      Notifications</a>
                  </li>
                  <li className="nav-item">
                    <a className="nav-link link text-black display-4" href="#">
                      About Us
                    </a>
                  </li></ul>
                <div className="navbar-buttons mbr-section-btn"><a className="btn btn-sm btn-primary display-4" href="#">
                    Log Out</a></div>
              </div>
            </nav>
          </section>
          <section className="engine"></section><section className="header1 cid-rB4qRp8JKI" id="header16-2">
            <div className="container">
            <Sidebar/>
              <div className="row justify-content-md-center">
                <div className="col-md-10 align-center">
                  <div className="mbr-section-btn"><a className="btn btn-md btn-primary display-4" href="#">Add Credit</a></div>
                </div>
              </div>
            </div>
          </section>
          <section className="counters2 counters cid-rB4rT8mBKN" id="counters2-3">
            <div className="container pt-4 mt-2">
            <h3 className="mbr-section-subtitle pb-5 align-left mbr-fonts-style display-5">Your Credit cards</h3>
              <div className="media-container-row">
                <div className="media-block" style={{width: '22%'}}>
                  <div className="mbr-figure">
                    <img src="assets/images/mbr-1024x647.jpg" alt="" title />
                  </div>
                </div>
                <div className="cards-block">
                    <div className="card px-3 align-left col-12 col-md-6">
                          <h3 className="count py-3 mbr-fonts-style display-7">Credit Card<br /><br />4422 2156 0567 9000</h3>
                    </div>
                </div>
              </div>
            </div>
          </section>
        </div>
        );
    };