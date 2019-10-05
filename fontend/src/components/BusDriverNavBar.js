import React, {Component} from 'react';
import Cookies from 'universal-cookie';

export default class BusDriverNavBar extends Component {

    constructor() {
        super();
        const userDetails = new Cookies();
        this.state = {
            name: userDetails.get('username'),
            busRoute: '' ,
            isCrowded: 'Not Crowded' ,
        };

        this.Home = this.Home.bind(this);
        this.logout = this.logout.bind(this);
    }

    async componentDidMount() {
        var busRoute = '',
            busRoute = await fetch(`/getBusRoute?busId=${this.state.name}`)
                .then(function (response) {
                    return response.text();
                })
                .then(function (data) {
                    return data;
                });
        var crowded = false ,
            crowded = await fetch(`/getBusIsOverCrowded?busId=${this.state.name}`)
                .then(function (response) {
                    return response.json();
                })
                .then(function (data) {
                    return data ;
                });
        if(crowded){
            this.setState({
                busRoute: busRoute,
                isCrowded: 'Over Crowded'
            })
        }else{
            this.setState({
                busRoute: busRoute,
                isCrowded: 'Not Crowded'
            })
        }
        const userDetails = new Cookies();
        userDetails.get('busRoute');
        userDetails.set('busRoute', this.state.busRoute);
    }

    Home()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'busDriverMain');
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
                                <span className="navbar-caption-wrap"><a className="navbar-caption text-primary display-5" onClick={this.Home}>SMARTBUSTICKETING</a></span>
                            </div>
                        </div>
                        <div className="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul className="navbar-nav nav-dropdown" data-app-modern-menu="true">
                                <li className="nav-item">
                                    <a className="nav-link link text-black display-4" href="#">{this.state.isCrowded}</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link link text-black display-4" href="#">{this.state.busRoute}</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link link text-black display-4" href="#">logged in as {this.state.name}</a>
                                </li>
                            </ul>
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