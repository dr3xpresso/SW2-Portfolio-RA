# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2025.09.19

### Added

- Designed a music playlist component
- Designed a trick tracker component
- Designed a photo library component

## 2025.10.25

### Added

- Designed kernel and enhanced interfaces for playlist component

### Updated

- Changed design to include playlistKernel and playlist interfaces
- Shuffle and startFrom methods introduced.
- Added Song subclass to PlaylistKernel
- Changed method headers in the interfaces to change from generic song type to song
- Changed method headers in the playlist enhanced interface to treat Queue<Pair<S, A>> as this.
