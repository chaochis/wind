// eslint-disable-next-line import/no-extraneous-dependencies
import { defineConfig } from 'vite';
// eslint-disable-next-line import/no-extraneous-dependencies
import vue from '@vitejs/plugin-vue';
import vueJsx from '@vitejs/plugin-vue-jsx';
import * as path from 'path';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), vueJsx()],
  base: '/',
  minify: 'esbuild',
  server: {
    port: 80,
    host: '0.0.0.0',
  },
  build: {
    rollupOptions: {
      output: {
        chunkFileNames: 'static/js/[name]-[hash].js',
        entryFileNames: 'static/js/[name]-[hash].js',
        assetFileNames: 'static/[ext]/[name]-[hash].[ext]',
      },
    },
  },
  resolve: {
    alias: [
      { find: '@', replacement: path.resolve('src') },
    ],
  },
  css: {
    postcss: {
      plugins: [
        {
          postcssPlugin: 'internal:charset-removal',
          AtRule: {
            charset: (atRule) => {
              if (atRule.name === 'charset') {
                atRule.remove();
              }
            }
          }
        }
      ]
    },
    preprocessorOptions: {
      scss: {
        additionalData: '@import "./src/assets/style/common_variable.scss";',
      },
    },
  },
  optimizeDeps: {
    include: ['lodash-es'],
  },
});
