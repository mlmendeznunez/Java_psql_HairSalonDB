# Java_psql_HairSalonDB

##### Database for Hair Salons to search for clients and stylists, August 30, 2015

#### By Marie Mendez-Nunez

## Description

This application enables hair salons to save the name of stylists.  Stylists can add clients.  These can be updated or deleted.  

## Setup

* $ createdb
* $ psql
* # CREATE DATABASE hair_salon;
* # \c hair_salon
* # CREATE TABLE  stylists (id serial PRIMARY KEY, name varchar); 
* # SELECT * from stylists;
* # CREATE TABLE clients (id serial PRIMARY KEY, name varchar, phone varchar, email varchar, address varchar, stylist_id int); 
* # SELECT * from clients;
* # CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

## Technologies Used

Spark 2.1, Velocity 1.7, Sql2o 1.5.4, Postgresql 9.4-1201-jbdc41, FluentLenium 

### Legal

Copyright (c) 2015 **Marie L. Mendez-Nunez**

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.