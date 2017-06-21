/*
    ./webpack.config.js
*/

const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const HtmlWebpackPluginConfig = new HtmlWebpackPlugin({
  template: './client/index.html',
  filename: 'index.html',
  inject: 'body'
})

module.exports = {
  entry: './client/index.js',
  output: {
    path: path.resolve('dist'),
    filename: 'index_bundle.js'
  }
  module: {
    loaders: [
      { test: /\.(js|jsx)$/i, loader: 'babel-loader', exclude: /node_modules/ },
      { test: /\.scss$/, use: ExtractTextPlugin.extract({use: 'sass-loader'}) },
      { test: /\.css$/, use: ['style-loader', 'css-loader']},
      { test: /\.(jpe?g|png|gif|svg)$/i,loaders:['url-loader?limit=10000',  'img-loader']}

    ]
    },
    plugins: [HtmlWebpackPluginConfig, new ExtractTextPlugin("styles/root.css")]
  }
