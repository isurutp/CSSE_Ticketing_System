import React, {Component} from 'react';
import Cookies from 'universal-cookie';

export default class AdminNavBar extends Component {
    Home()
    {
            const cookies = new Cookies();
            cookies.get('page');
            cookies.set('page', 'admin');
            window.location.reload();  
    }

    logout()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'login');
        window.location.reload();  
    }

    render() {
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
                        <h2 style={{textAlign: 'center', color:'blue'}} onClick={this.Home}>Transport Management Service</h2>
                    </div>
                    </div>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <div className="navbar-buttons mbr-section-btn">
                        <button className="btn btn-sm btn-primary display-4" href="#" onClick={this.logout}>Log Out</button>
                    </div>
                    </div>
                </nav>
                </section>
            </div>
        );
    }
};