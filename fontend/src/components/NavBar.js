import React, {Component} from 'react';

export default class NavBar extends Component {
    render() {
            var alertBox = {
                padding: "20px",
                backgroundColor: "#2196F3", /* Red */
                color: "white",
                marginBottom: "15px",
                zIndex:1
            };

            return (
            <div>
                {/* Navigation Bar */}
                <section className="menu cid-rB4nPyNx2i" once="menu" id="menu2-0">
                <nav className="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm">
                    
                    {/* Hamburger Menu for Portrait layout  */}
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
            </div>
        );
    }
};