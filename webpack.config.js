const sjsConfig = require('./scalajs.webpack.config');
sjsConfig.output.libraryTarget = 'commonjs2';
sjsConfig.mode = 'development';
sjsConfig.target = 'node';

module.exports = sjsConfig
