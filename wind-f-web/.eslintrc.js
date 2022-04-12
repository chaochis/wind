module.exports = {
  // 使用airbnb会导致idea的eslint检测机制不同步
  extends: ['plugin:vue/vue3-essential', 'airbnb-base'],
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  parserOptions: {
    ecmaVersion: 2021,
    sourceType: 'module',
    allowImportExportEverywhere: true,
  },
  plugins: ['vue'],
  rules: {
    // 自己写一些想配置的规则
    'no-console': ['error', { allow: ['warn', 'error', 'log'] }],
  },
  overrides: [
    {
      files: ['*.vue'],
      rules: {
        // 这里写覆盖vue文件的规则
      },
    },
  ],
  settings: {
    'import/resolver': {
      alias: {
        map: [
          ['@', './src'],
        ],
        extensions: ['.js', '.jsx', '.json', '.vue'],
      },
    },
  },
};
